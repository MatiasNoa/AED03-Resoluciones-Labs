/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

/**
 *
 * @author Asus
 */
public class Test {
    public static void main(String[] args) {
        BSTree<Integer> arbol = new BSTree<>();

        try {
            arbol.insert(50);
            arbol.insert(30);
            arbol.insert(70);
            arbol.insert(20);
            arbol.insert(40);
            arbol.insert(60);
            arbol.insert(80);
        } catch (ItemDuplicated e) {
            e.printStackTrace();
        }
        
        try {
            arbol.remove(30);
        } catch (ItemNotFound e) {
            e.printStackTrace();
        }
        System.out.println(arbol);
        
        System.out.println(arbol);
        
//        try {
//            System.out.println("Valor minimo: " + arbol.encontrarMin());
//        } catch (ItemNotFound e) {
//            e.printStackTrace();
//        }
//        
//        System.out.println("Número de nodos no-hojas: " + arbol.countNodes()); 
//        System.out.println("Número de nodos (contando hojas): " + arbol.countNodesRec()); 
        System.out.println("Numero de hojas: " + arbol.countHojas());
//        
//        try {
//            System.out.println("Altura del arbol: " + arbol.height(50));
//        } catch (ItemNotFound e) {
//            e.printStackTrace();
//        }
//        
//        System.out.println("Area del arbol: " + arbol.areaBST()); 
        System.out.println("Recorrido PreOrden del arbol: "); arbol.iterativePreOrden(); 
//    }
//    
//    public static boolean sameArea(BSTree arb1, BSTree arb2){
//        if (arb1 == arb2){
//            System.out.println("Los árboles son iguales");
//            return true;
//        }
//        else return arb1.areaBST() == arb2.areaBST();
    }
}
