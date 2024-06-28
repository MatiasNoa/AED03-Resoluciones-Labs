/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listlinked;

/**
 *
 * @author Asus
 */
public class QueueLink<E> {

    private NodeCola<E> first;
    private NodeCola<E> last;

    public QueueLink() {
        this.first = null;
        this.last = null;
    }

    public void enqueue(E x) {
        NodeCola<E> aux = new NodeCola<E>(x);
        if (isEmpty()) {
            first = aux;
        } else if (last == null) {
            first.setNext(aux);
            last = aux;
        } else {
            last.setNext(aux);
            last = aux;
        }
    }

    public E dequeue() throws ExceptionIsEmpty {
        try {
            if (isEmpty()) {
                throw new ExceptionIsEmpty("La cola esta vacia");
            }
            E data = first.getData();
            first = first.getNext();
            if (first == last) {
                last = null;
            }
            return data;
        } catch (ExceptionIsEmpty e) {
            System.out.println("La cola esta vacia.");
            return null;
        }
    }

    public E back() throws ExceptionIsEmpty {
        try {
            if (isEmpty()) {
                throw new ExceptionIsEmpty("La cola esta vacia.");
            } else if (last == null) {
                return first.getData();
            } else {
                return last.getData();
            }
        } catch (ExceptionIsEmpty e) {
            System.out.println("La cola esta vacia");
            return null;
        }
    }

    public E front() throws ExceptionIsEmpty {
        try {
            if (isEmpty()) {
                throw new ExceptionIsEmpty("La cola esta vacia.");
            }
            return first.getData();
        } catch (ExceptionIsEmpty e) {
            System.out.println("La cola esta vacia");
            return null;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String toString() {
        String message = "";
        if (isEmpty()) {
            message = "La cola esta vacia.";
        } else {
            NodeCola<E> aux = first;
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
