/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

/**
 *
 * @author Asus
 */
public class StackLink<E> {

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

    public StackLink() {
        this.first = null;
    }

    public void push(E x) {
        Node<E> aux = new Node<E>(x);
        if (isEmpty()) {
            first = aux;
        } else {
            aux.setNext(first);
            first = aux;
        }
    }

    public E pop() throws ExceptionIsEmpty {
        try {
            if (isEmpty()) {
                throw new ExceptionIsEmpty("La pila esta vacia.");
            }
            E data = first.getData();
            first = first.getNext();
            return data;

        } catch (ExceptionIsEmpty e) {
            System.out.println("La pila esta vacia.");
            return null;
        }
    }

    public E top() throws ExceptionIsEmpty {
        try {
            if (isEmpty()) {
                throw new ExceptionIsEmpty("La pila esta vacia.");
            }
            return first.getData();

        } catch (ExceptionIsEmpty e) {
            System.out.println("La pila esta vacia.");
            return null;
        }
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public String toString() {
        String message = "";
        if (isEmpty()) {
            message = "La pila esta vacia.";
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
