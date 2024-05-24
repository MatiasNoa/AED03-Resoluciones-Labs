/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;
import java.util.Random;

/**
 *
 * @author Asus
 */
public class TestAVL {
    
    public static void main(String[] args) {
        // Comparacion de alturas de los arboles
        try {
            
            BSTree<Integer> bst = new BSTree<>();
            AVLTree<Integer> avl = new AVLTree<>();
            
            for (int i = 1; i <= 10; i++) {
                bst.insert(i);
                avl.insert(i);

            }

            int bstHeight = bst.heightNode(bst.getRoot());
            int avlHeight = avl.heightNode(avl.getRoot());
            System.out.println("Altura del arbol BST: " + bstHeight);
            System.out.println("Altura del arbol AVL: " + avlHeight);
            
        } catch (ItemDuplicated e) {
            System.out.println("Error al insertar elemento duplicado: " + e.getMessage());
        }
        
        // Comparacion de tiempo de busqueda
        try {

            BSTree<Integer> bst = new BSTree<>();
            AVLTree<Integer> avl = new AVLTree<>();

            for (int i = 1; i <= 100; i++) {
                bst.insert(i);
                avl.insert(i);

            }

            long inicioBST = System.nanoTime();
            bst.search(75);
            long finBST = System.nanoTime();
            long duracionBST = finBST - inicioBST;
            
            long inicioAVL = System.nanoTime();
            bst.search(75);
            long finAVL = System.nanoTime();
            long duracionAVL = finAVL - inicioAVL;
            
            System.out.println("Tiempo de búsqueda en el árbol BST: " + duracionBST + " nanosegundos");
            System.out.println("Tiempo de búsqueda en el árbol AVL: " + duracionAVL + " nanosegundos");

        } catch (ItemDuplicated | ItemNotFound e) {
            System.out.println("Error al insertar elemento duplicado: " + e.getMessage());
        }
    }
}
