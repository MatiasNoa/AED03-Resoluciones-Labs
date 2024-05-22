/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

/**
 *
 * @author Asus
 */
public class BSTree<E extends Comparable<E>> {

    class Node {

        protected E data;
        protected Node left, right;

        public Node(E data) {
            this(data, null, null);
        }

        public Node(E data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;

    public BSTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(E x) {
        Node nodo = new Node(x);
        if (isEmpty()) {
            root = nodo;
        } else {
            Node p = null;
            Node current = root;
            while (current != null) {
                p = current;
                if (x.compareTo(p.data) < 0) {
                    current = current.left;
                    if (current == null) {
                        p.left = nodo;
                        return;
                    }
                } else if (x.compareTo(p.data) > 0) {
                    current = current.right;
                    if (current == null) {
                        p.right = nodo;
                        return;
                    }
                } else {
                    System.out.println("No se admiten duplicados");
                    return;
                }
            }
        }
    }

    public void remove(E x) throws ItemNotFound {
        Node parent = null;
        Node current = root;
        boolean isLeftChild = false;
        while (current != null && !current.data.equals(x)) {
            parent = current;
            if (x.compareTo(current.data) < 0) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
        }
        if (current == null) {
            throw new ItemNotFound("Dato no encontrado");
        }
        // Caso 1: Sin hijos
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } // Caso 2: Un hijo
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } // Caso 3: Dos Hijos
        else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
    }

    private Node getSuccessor(Node nodo) {
        Node successorParent = nodo;
        Node successor = nodo;
        Node current = nodo.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if (successor != nodo.right) {
            successorParent.left = successor.right;
            successor.right = nodo.right;
        }
        return successor;
    }

    public E search(E x) throws ItemNotFound {
        Node current = root;
        while (current != null) {
            if (x.compareTo(current.data) < 0) {
                current = current.left;
            } else if (x.compareTo(current.data) > 0) {
                current = current.right;
            } else {
                return current.data;
            }
        }
        throw new ItemNotFound("Dato no encontrado");
    }

    private Node minRemove() throws ItemNotFound {
        if (root == null) {
            throw new ItemNotFound("Dato no encontrado");
        }
        Node parent = null;
        Node current = root;
        while (current.left != null) {
            parent = current;
            current = current.left;
        }
        if (parent == null) {
            root = current.right;
        } else {
            parent.left = current.right;
        }
        return current;
    }

    public E encontrarMin() throws ItemNotFound {
        Node minNode = minRemove();
        return minNode.data;
    }

    public int countNodes() {
        if (isEmpty()) {
            return 0;
        }
        int count = 0;
        StackLink<Node> pila = new StackLink<>();
        pila.push(root);
        while (!pila.isEmpty()) {
            try {
                Node current = pila.pop();
                if (current.left != null || current.right != null) {
                    count++;
                }
                if (current.right != null) {
                    pila.push(current.right);
                }
                if (current.left != null) {
                    pila.push(current.left);
                }
            } catch (ExceptionIsEmpty e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    public int height(E x) throws ItemNotFound {
        if (isEmpty()) return -1;
        Node current = root;
        while (current != null && !current.data.equals(x)) {
            if (x.compareTo(current.data) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (current == null) {
            throw new ItemNotFound("Dato no encontrado");
        }
        return heightNode(current);
    }

    private int heightNode(Node node) {
        int height = -1;
        QueueLink<Node> cola = new QueueLink<>();
        cola.enqueue(node);
        while (!cola.isEmpty()) {
            int levelSize = cola.getSize();
            height++;
            for (int i = 0; i < levelSize; i++) {
                try {
                    Node current = cola.dequeue();
                    if (current.left != null) {
                        cola.enqueue(current.left);
                    }
                    if (current.right != null) {
                        cola.enqueue(current.right);
                    }
                } catch (ExceptionIsEmpty e) {
                    e.printStackTrace();
                }
            }
        }
        return height;
    }
    
    public int countHojas() {
        if (isEmpty()) {
            return 0;
        }
        int hojas = 0;
        QueueLink<Node> cola = new QueueLink<>();
        cola.enqueue(root);
        try {
            while (!cola.isEmpty()) {
                Node current = cola.dequeue();
                if (current.left == null && current.right == null) {
                    hojas++;
                } else {
                    if (current.left != null) {
                        cola.enqueue(current.left);
                    }
                    if (current.right != null) {
                        cola.enqueue(current.right);
                    }
                }
            }
        } catch (ExceptionIsEmpty e) {
            e.printStackTrace();
        }
        return hojas;
    }
    
    public int areaBST(){
        return heightNode(root) * countHojas(); 
    }
    
    public void iterativePreOrden() {
        if (root == null) {
            return;
        }
        StackLink<Node> pila = new StackLink<>();
        pila.push(root);
        try {
            while (!pila.isEmpty()) {
                Node current = pila.pop();
                System.out.print(current.data + " ");
                if (current.right != null) {
                    pila.push(current.right);
                }
                if (current.left != null) {
                    pila.push(current.left);
                }
            }
        } catch (ExceptionIsEmpty e) {
            e.printStackTrace();
        }
        System.out.println();
    }
    
    public int countNodesRec() {
        return countNodesRec(root);
    }

    private int countNodesRec(Node node) {
        if (node == null) {
            return 0;
        }
        int nodosIzq = countNodesRec(node.left);
        int nodosDer = countNodesRec(node.right);
        return nodosIzq + nodosDer + 1;
    }
    
    private void inOrder(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        inOrder(node.left, sb);
        sb.append(node.data).append(" ");
        inOrder(node.right, sb);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Datos (InOrder) del arbol:\n");
        inOrder(root, sb);
        return sb.toString();
    }
}
