/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

/**
 *
 * @author Asus
 */
public class ListLinked<T extends Comparable<T>> {
    
    class Node<T> {
        private T data;
        private Node<T> next;
        
        Node(T data){
            this(data,null);
        }
        
        Node(T d, Node<T> n){
            this.data = d;
            this.next = n;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    
    }

    protected Node<T> first;

    public ListLinked() {
        this.first = null;
    }

    @Override
    public boolean isEmptyList() {
        return this.first == null;
    }

    @Override
    public int length() {
        Node<T> aux = this.first;
        int length = 0;
        while(aux != null){
            length++;
            aux = aux.getNext();
        }
        return length;
    }

    @Override
    public void destroyList() {
        this.first = null;
    }

    @Override
    public int search(T x) {
        Node<T> aux = this.first;
        int i = 0;
        while(aux != null){
            if (aux.getData().equals(x))
                return i;
            i++;
            aux = aux.getNext();
        }
        return -1;
    }

    @Override
    public void insertFirst(T x) {
        Node<T> nuevo = new Node<T>(x);
        nuevo.setNext(this.first);
        this.first = nuevo;
    }

    @Override
    public void insertLast(T x) {
        Node<T> nuevo = new Node<T>(x);
        Node<T> aux = this.first;
        if(this.first == null){
            this.insertFirst(x);
        }
        else {
            while(aux.getNext()!= null){
                aux = aux.getNext();
            }
            aux.setNext(nuevo);
        }
    }
    
    @Override
    public void removeNode(T x) {
        if (first == null) {
            return;
        }
        if (first.getData().equals(x)) {
            first = first.getNext();
            return;
        }
        Node<T> aux = first;
        while (aux.getNext() != null) {
            if (aux.getNext().getData().equals(x)) { 
                aux.setNext(aux.getNext().getNext());
                return;
            }
            aux = aux.getNext();
        }
    }

    @Override
    public void imprimirLista() {
        System.out.println("Lista:");
        Node<T> aux = this.first;
        while (aux != null){
            System.out.println(aux.getData());
            aux = aux.getNext();
        }
    }
    
    public void deleteDuplicates() {
        Node<T> aux = first;
        while (aux != null) {
            Node<T> buscador = aux;
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
    
    public void insertNth(T x, int p){
        if (p == 0){
            this.insertFirst(x);
            return;
        }
        Node<T> nuevo = new Node<T>(x);
        int i = 0;
        Node<T> aux = first;
        while (aux.getNext() != null && i < p-1){
            aux = aux.getNext();
            i++;
        }
        if (i != p-1){
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
        Node<T> aux = first;
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
