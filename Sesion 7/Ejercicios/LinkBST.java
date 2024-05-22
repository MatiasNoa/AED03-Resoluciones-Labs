/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Ejercicio1;


/**
 *
 * @author Asus
 */
public interface LinkBST<E> {
    void insert(E x) throws ItemDuplicated;
    void remove(E x);
    E search(E x) throws ItemDuplicated;
    boolean isEmpty();
}
