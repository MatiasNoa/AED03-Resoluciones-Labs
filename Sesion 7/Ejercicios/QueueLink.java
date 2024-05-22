/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

/**
 *
 * @author Asus
 */
public class QueueLink<E> {
    
    class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "" + this.data;
        }
    }
    
    private Node<E> first;
    private Node<E> last;
    private int size;

    public QueueLink() {
        this.first = null;
        this.last = null;
        this.size = 0; 
    }

    public void enqueue(E x) {
        Node<E> aux = new Node<E>(x);
        if (isEmpty()) {
            first = aux;
            last = aux;
        } else if (last == first) {
            first.setNext(aux);
            last = aux;
        } else {
            last.setNext(aux);
            last = aux;
        }
        size++; 
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola esta vacia.");
        }
        E data = first.getData();
        first = first.getNext();
        if (first == null) {
            last = null;
        }
        size--; 
        return data;
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola esta vacia.");
        }
        return last.getData();
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola esta vacia.");
        }
        return first.getData();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int getSize() { 
        return size;
    }

    public String toString() {
        String message = "";
        if (isEmpty()) {
            message = "La cola esta vacia.";
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
}
