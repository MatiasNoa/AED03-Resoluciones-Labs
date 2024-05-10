/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ejercicio3;

/**
 *
 * @author Asus
 */
public interface Queue<E> {

    void enqueue(E x);

    E dequeue() throws ExceptionIsEmpty;

    E front() throws ExceptionIsEmpty;

    E back() throws ExceptionIsEmpty;

    boolean isEmpty();
}
