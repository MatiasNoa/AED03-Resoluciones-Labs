package avltree;

public class TestAVL {
    public static void main(String[] args) {
        try {
            AVLTree<Integer> avl = new AVLTree<>();

            // Caso 1: Rotación Simple a la Derecha (RSR)
            avl.insert(30);
            avl.insert(20);
            avl.insert(10);
            System.out.println("Caso 1 (RSR): " + avl.root);

            // Caso 2: Rotación Simple a la Izquierda (RSL)
            avl = new AVLTree<>();
            avl.insert(10);
            avl.insert(20);
            avl.insert(30);
            System.out.println("Caso 2 (RSL): " + avl.root);

            // Caso 3: Rotación Doble a la Derecha (RDR)
            avl = new AVLTree<>();
            avl.insert(30);
            avl.insert(10);
            avl.insert(20);
            System.out.println("Caso 3 (RDR): " + avl.root);

            // Caso 4: Rotación Doble a la Izquierda (RDL)
            avl = new AVLTree<>();
            avl.insert(10);
            avl.insert(30);
            avl.insert(20);
            System.out.println("Caso 4 (RDL): " + avl.root);

            // Caso 5: Rotación Simple a la Derecha (RSR)
            avl = new AVLTree<>();
            avl.insert(50);
            avl.insert(40);
            avl.insert(30);
            avl.insert(20);
            avl.insert(10);
            System.out.println("Caso 5 (RSR): " + avl.root);

            // Caso 6: Rotación Simple a la Izquierda (RSL)
            avl = new AVLTree<>();
            avl.insert(10);
            avl.insert(20);
            avl.insert(30);
            avl.insert(40);
            avl.insert(50);
            System.out.println("Caso 6 (RSL): " + avl.root);

            // Caso 7: Rotación Doble a la Derecha (RDR)
            avl = new AVLTree<>();
            avl.insert(50);
            avl.insert(20);
            avl.insert(30);
            avl.insert(10);
            avl.insert(40);
            System.out.println("Caso 7 (RDR): " + avl.root);

            // Caso 8: Rotación Doble a la Izquierda (RDL)
            avl = new AVLTree<>();
            avl.insert(10);
            avl.insert(40);
            avl.insert(30);
            avl.insert(50);
            avl.insert(20);
            System.out.println("Caso 8 (RDL): " + avl.root);

        } catch (ItemDuplicated e) {
            e.printStackTrace();
        }
    }
}