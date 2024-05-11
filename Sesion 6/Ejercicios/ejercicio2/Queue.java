package Ejercicios.ejercicio2;

public interface Queue<E> {

    void enqueue(E x);

    E dequeue() throws ExceptionIsEmpty;

    E front() throws ExceptionIsEmpty;

    E back() throws ExceptionIsEmpty;

    boolean isEmpty();
}
