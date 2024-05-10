/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ejercicio4;

/**
 *
 * @author Asus
 */
public interface Stack<E>{
    void push(E x);
    E pop() throws ExceptionIsEmpty;
    E top() throws ExceptionIsEmpty;
    boolean isEmpty();
}