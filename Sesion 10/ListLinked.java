public class ListLinked<E extends Comparable<E>> {

    protected Node<E> first;

    public ListLinked() {
        this.first = null;
    }

    public Node<E> getFirst() {
        return first;
    }

    
    public boolean isEmptyList() {
        return this.first == null;
    }

    
    public int length() {
        Node<E> aux = this.first;
        int length = 0;
        while (aux != null) {
            length++;
            aux = aux.getNext();
        }
        return length;
    }

    
    public void destroyList() {
        this.first = null;
    }

    
    public int search(E x) {
        Node<E> aux = this.first;
        int i = 0;
        while (aux != null) {
            if (aux.getData().equals(x)) {
                return i;
            }
            i++;
            aux = aux.getNext();
        }
        return -1;
    }

    
    public void insertFirst(E x) {
        Node<E> nuevo = new Node<E>(x);
        nuevo.setNext(this.first);
        this.first = nuevo;
    }

    
    public void insertLast(E x) {
        Node<E> nuevo = new Node<E>(x);
        Node<E> aux = this.first;
        if (this.first == null) {
            this.insertFirst(x);
        } else {
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(nuevo);
        }
    }

    
    public void removeNode(E x) {
        if (first == null) {
            return;
        }
        if (first.getData().equals(x)) {
            first = first.getNext();
            return;
        }
        Node<E> aux = first;
        while (aux.getNext() != null) {
            if (aux.getNext().getData().equals(x)) {
                aux.setNext(aux.getNext().getNext());
                return;
            }
            aux = aux.getNext();
        }
    }

    
    public void imprimirLista() {
        System.out.println("Lista:");
        Node<E> aux = this.first;
        while (aux != null) {
            System.out.println(aux.getData());
            aux = aux.getNext();
        }
    }
    
    public String toString() {
        String message = "";
        if (isEmptyList()) {
            message = "La lista esta vacia.";
        } else {
            Node<E> aux = first;
            message += aux;
            while (aux.getNext() != null) {
                message += " -> ";
                message += aux.getNext();
                aux = aux.getNext();
            }
        }
        return message;
    }

    public void deleteDuplicates() {
        Node<E> aux = first;
        while (aux != null) {
            Node<E> buscador = aux;
            while (buscador.getNext() != null) {
                if (buscador.getNext().getData().equals(aux.getData())) {
                    buscador.setNext(buscador.getNext().getNext());
                } else {
                    buscador = buscador.getNext();
                }
            }
            aux = aux.getNext();
        }
    }

    public void insertNth(E x, int p) {
        if (p == 0) {
            this.insertFirst(x);
            return;
        }
        Node<E> nuevo = new Node<E>(x);
        int i = 0;
        Node<E> aux = first;
        while (aux.getNext() != null && i < p - 1) {
            aux = aux.getNext();
            i++;
        }
        if (i != p - 1) {
            System.out.println("Fuera de rango");
            return;
        }
        nuevo.setNext(aux.getNext());
        aux.setNext(nuevo);
    }

    public void deleteNth(int p) {
        if (p == 0) {
            if (first != null) {
                first = first.getNext();
            }
            return;
        }
        int i = 0;
        Node<E> aux = first;
        while (aux != null && i < p - 1) {
            aux = aux.getNext();
            i++;
        }
        if (aux == null || aux.getNext() == null) {
            System.out.println("Fuera de rango");
            return;
        }
        aux.setNext(aux.getNext().getNext());
    }

}