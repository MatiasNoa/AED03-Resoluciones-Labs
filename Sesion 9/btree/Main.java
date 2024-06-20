
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            BTree<Integer> arbolBtreeInteger = new BTree<>(4);
            BTree<Integer> arbolTXT;
//
            arbolBtreeInteger.insert(19);
            arbolBtreeInteger.insert(30);
            arbolBtreeInteger.insert(3);
//            arbolBtreeInteger.insert(4);
//            arbolBtreeInteger.insert(12);
            arbolBtreeInteger.insert(20);
            arbolBtreeInteger.insert(22);
            arbolBtreeInteger.insert(40);

            System.out.println(arbolBtreeInteger);

            arbolBtreeInteger.remove(20);
            arbolBtreeInteger.remove(22);

            System.out.println(arbolBtreeInteger);


            arbolTXT = BTree.building_Btree("archivo.txt");
            System.out.println(arbolTXT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}