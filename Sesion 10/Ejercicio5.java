import java.util.ArrayList;
import java.util.List;

public class Ejercicio5 {
    private int tamaño;
    private List<List<Integer>> tabla;

    public Ejercicio5(int tamaño) {
        this.tamaño = tamaño;
        this.tabla = new ArrayList<>(tamaño);
        for (int i = 0; i < tamaño; i++) {
            this.tabla.add(null);
        }
    }

    private int hash(int clave) {
        return clave % tamaño;
    }

    public void insertar(int clave) {
        int indice = hash(clave);
        List<Integer> lista = tabla.get(indice);

        if (lista == null) {
            lista = new ArrayList<>();
            tabla.set(indice, lista);
        }

        lista.add(clave);
    }

    public boolean buscar(int clave) {
        int indice = hash(clave);
        List<Integer> lista = tabla.get(indice);

        return lista != null && lista.contains(clave);
    }

    // Método para encontrar pares que sumen el valor dado
    public List<List<Integer>> encontrarPares(List<Integer> lista, int suma) {
        List<List<Integer>> pares = new ArrayList<>();
        for (int numero : lista) {
            int complemento = suma - numero;
            if (buscar(complemento)) {
                List<Integer> nuevoPar = new ArrayList<>();
                nuevoPar.add(complemento);
                nuevoPar.add(numero);
                pares.add(nuevoPar);
            }
            insertar(numero);
        }
        return pares;
    }

    public static void main(String[] args) {
        List<Integer> lista = List.of(1, 2, 3, 4, 5);
        int suma = 6;

        Ejercicio5 tabla = new Ejercicio5(10);
        List<List<Integer>> paresEncontrados = tabla.encontrarPares(lista, suma);

        System.out.println("Pares que suman " + suma + ":");
        for (List<Integer> par : paresEncontrados) {
            System.out.println(par.get(0) + ", " + par.get(1));
        }
    }
}