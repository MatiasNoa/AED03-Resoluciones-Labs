/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author Asus
 */
public class BTree<E extends Comparable<E>> {

    private BNode<E> root;
    private int orden;
    private boolean up;
    private BNode<E> nDes;

    public BTree(int orden) {
        this.orden = orden;
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(E cl) {
        up = false;
        E mediana;
        BNode<E> pnew;
        mediana = push(this.root, cl);
        if (up) {
            pnew = new BNode<>(this.orden);
            pnew.count = 1;
            pnew.keys.set(0, mediana);
            pnew.childs.set(0, this.root);
            pnew.childs.set(1, nDes);
            if (this.root != null) {
                this.root.parent = pnew;
            }
            if (nDes != null) {
                nDes.parent = pnew;
            }
            this.root = pnew;
        }
    }

    private E push(BNode<E> current, E cl) {
        int[] pos = new int[1];
        E mediana;
        if (current == null) {
            up = true;
            nDes = null;
            return cl;
        } else {
            boolean fl;
            fl = current.searchNode(cl, pos);
            if (fl) {
                System.out.println("Item duplicado\n");
                up = false;
                return null;
            }
            mediana = push(current.childs.get(pos[0]), cl);
            if (up) {
                if (current.nodeFull(this.orden - 1)) {
                    mediana = dividedNode(current, mediana, pos[0]);
                } else {
                    up = false;
                    putNode(current, mediana, nDes, pos[0]);
                }
            }
            return mediana;
        }
    }

    private void putNode(BNode<E> current, E cl, BNode<E> rd, int k) {
        int i;
        for (i = current.count - 1; i >= k; i--) {
            current.keys.set(i + 1, current.keys.get(i));
            current.childs.set(i + 2, current.childs.get(i + 1));
        }
        current.keys.set(k, cl);
        current.childs.set(k + 1, rd);
        current.count++;
        if (rd != null) {
            rd.parent = current;
        }
    }

    private E dividedNode(BNode<E> current, E cl, int k) {
        BNode<E> rd = nDes;
        int i, posMdna;
        posMdna = (k <= this.orden / 2) ? this.orden / 2 : this.orden / 2 + 1;
        nDes = new BNode<>(this.orden);
        for (i = posMdna; i < this.orden - 1; i++) {
            nDes.keys.set(i - posMdna, current.keys.get(i));
            nDes.childs.set(i - posMdna + 1, current.childs.get(i + 1));
        }
        nDes.count = (this.orden - 1) - posMdna;
        current.count = posMdna;
        if (k <= this.orden / 2) {
            putNode(current, cl, rd, k);
        } else {
            putNode(nDes, cl, rd, k - posMdna);
        }
        E median = current.keys.get(current.count - 1);
        nDes.childs.set(0, current.childs.get(current.count));
        current.count--;
        if (nDes.childs.get(0) != null) {
            nDes.childs.get(0).parent = nDes;
        }
        for (i = 1; i <= nDes.count; i++) {
            if (nDes.childs.get(i) != null) {
                nDes.childs.get(i).parent = nDes;
            }
        }
        return median;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IdNodo\tClaves Nodo\tIdPadre\t\tIdHijos\n");
        sb.append(writeTree(this.root));
        return sb.toString();
    }

    private String writeTree(BNode<E> node) {
        if (node == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(node.idNode).append("\t")
                .append(node.keys.subList(0, node.count)).append("\t\t")
                .append(node.parent != null ? node.parent.idNode : "null").append("\t\t")
                .append("[");
        for (int i = 0; i <= node.count; i++) {
            if (node.childs.get(i) != null) {
                sb.append(node.childs.get(i).idNode);
                if (i < node.count) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]\n");
        for (int i = 0; i <= node.count; i++) {
            sb.append(writeTree(node.childs.get(i)));
        }
        return sb.toString();
    }


    public boolean search(E cl) {
        return searchRecursive(this.root, cl);
    }

    private boolean searchRecursive(BNode<E> current, E cl) {
        if (current == null) {
            return false;
        }
        int[] pos = new int[1];
        boolean found = current.searchNode(cl, pos);
        if (found) {
            System.out.println(cl + " se encuentra en el nodo " + current.idNode + " en la posicion " + pos[0]);
            return true;
        } else {
            return searchRecursive(current.childs.get(pos[0]), cl);
        }
    }
}

