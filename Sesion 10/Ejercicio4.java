
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ejercicio4 {
    private int tamaño;
    private List<List<Entry>> tabla;

    public Ejercicio4(int tamaño) {
        this.tamaño = tamaño;
        this.tabla = new ArrayList<>(tamaño);
        for (int i = 0; i < tamaño; i++) {
            this.tabla.add(null);
        }
    }

    private class Entry {
        String clave;
        int frecuencia;

        Entry(String clave, int frecuencia) {
            this.clave = clave;
            this.frecuencia = frecuencia;
        }
    }

    // Función hash
    private int hash(String clave) {
        return Math.abs(clave.hashCode()) % tamaño;
    }

    // Método para insertar una palabra y contar su frecuencia
    public void insertar(String clave) {
        int indice = hash(clave);
        List<Entry> lista = tabla.get(indice);

        if (lista == null) {
            lista = new LinkedList<>();
            tabla.set(indice, lista);
        }

        // Buscar la palabra en la lista
        for (Entry entry : lista) {
            if (entry.clave.equals(clave)) {
                entry.frecuencia++;
                return;
            }
        }

        // Si no se encuentra, agregarla con frecuencia 1
        lista.add(new Entry(clave, 1));
    }

    // Método para obtener la frecuencia de una palabra
    public int frecuencia(String clave) {
        int indice = hash(clave);
        List<Entry> lista = tabla.get(indice);

        if (lista != null) {
            for (Entry entry : lista) {
                if (entry.clave.equals(clave)) {
                    return entry.frecuencia;
                }
            }
        }

        return 0;
    }

    public void imprimirTabla() {
        for (int i = 0; i < tamaño; i++) {
            List<Entry> lista = tabla.get(i);
            if (lista != null) {
                System.out.print("[" + i + "]: ");
                for (Entry entry : lista) {
                    System.out.print("(" + entry.clave + ", " + entry.frecuencia + ") ");
                }
                System.out.println();
            } else {
                System.out.println("[" + i + "]: null");
            }
        }
    }
    //PRUEBAS
    public static void main(String[] args) {
        String texto = "hola mundo hola adios mundo mundo";
        String[] palabras = texto.split("\\s+"); // Dividir por espacios en blanco

        Ejercicio4 tabla = new Ejercicio4(10);

        for (String palabra : palabras) {
            tabla.insertar(palabra);
        }

        System.out.println("Cantidad de hola: "+tabla.frecuencia("hola"));
        System.out.println("Cantidad de mundo: "+tabla.frecuencia("mundo"));
        System.out.println("Cantidad de adios: "+tabla.frecuencia("adios"));

        // Imprimir la tabla hash (opcional)
        tabla.imprimirTabla();
    }
}
