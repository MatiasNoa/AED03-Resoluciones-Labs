import java.util.List;

public class Ejercicio5 {
    public static void main(String[] args) {
        TablaHashSuma tabla = new TablaHashSuma(10);

        tabla.insert(3);
        tabla.insert(7);
        tabla.insert(4);
        tabla.insert(5);
        tabla.insert(10);

        int targetSum = 10;
        List<String> pares = tabla.encontrarParesQueSumen(targetSum);

        if (!pares.isEmpty()) {
            System.out.println("Pares que suman " + targetSum + ":");
            for (String par : pares) {
                System.out.println(par);
            }
        } else {
            System.out.println("No se encontraron pares que sumen " + targetSum);
        }
    }
}