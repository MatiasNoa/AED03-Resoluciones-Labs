/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listlinked;

/**
 *
 * @author Asus
 */
public class NodeCola<T> {

    private T data;
    private NodeCola<T> next;

    public NodeCola(T data) {
        this.data = data;
        this.next = null;
    }

    public NodeCola(T data, NodeCola<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public NodeCola<T> getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(NodeCola<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "" + this.data;
    }
}
