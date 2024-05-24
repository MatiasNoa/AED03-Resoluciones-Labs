/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

/**
 *
 * @author Asus
 */
public class TestEj3 {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();

        try {
            tree.insert(10);
            tree.insert(5);
            tree.insert(15);
            tree.insert(3);
            tree.insert(8);
            tree.insert(12);
            tree.insert(20);
            tree.insert(4);
            tree.insert(7);
            tree.insert(13);
            tree.insert(18);
        } catch (ItemDuplicated e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Recorrdio por amplitud:");
        tree.recorridoAmplitud();
    }
}
