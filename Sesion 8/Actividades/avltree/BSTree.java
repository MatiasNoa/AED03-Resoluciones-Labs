package avltree;

public class BSTree<E extends Comparable<E>> {

    class Node{

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

    protected Node root;

    public BSTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(E x) throws ItemDuplicated{
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
                    throw new ItemDuplicated("No se permiten duplicados");
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
    
}
