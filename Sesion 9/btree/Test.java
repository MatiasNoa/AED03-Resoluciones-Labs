/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

/**
 *
 * @author Asus
 */
public class Test {

    public static void main(String[] args) {
        BTree<Integer> bTree = new BTree<>(3);

        bTree.insert(10);
        bTree.insert(20);
        bTree.insert(5);
        bTree.insert(6);
        bTree.insert(12);
        bTree.insert(30);
        bTree.insert(7);
        bTree.insert(17);
        
        System.out.println(bTree);
        
        
        System.out.println(bTree.search(12));
    }
}
