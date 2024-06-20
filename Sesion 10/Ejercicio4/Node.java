package Ejercicio4;
public class Node<T> {
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

    @Override
    public String toString() {
        return "" +data;
    }

}