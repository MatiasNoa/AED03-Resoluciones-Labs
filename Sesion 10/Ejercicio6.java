import java.util.ArrayList;
import java.util.List;

public class Ejercicio6 {
    private int tamaño;
    private List<List<Entry>> tabla;

    public Ejercicio6(int tamaño) {
        this.tamaño = tamaño;
        this.tabla = new ArrayList<>(tamaño);
        for (int i = 0; i < tamaño; i++) {
            this.tabla.add(null);
        }
    }

    private class Entry {
        int[] clave;
        Object valor;

        Entry(int[] clave, Object valor) {
            this.clave = clave;
            this.valor = valor;
        }

        public int[] getClave() {
            return clave;
        }

        public Object getValor() {
            return valor;
        }
    }

    private int hash(int[] clave) {
        return (clave[0] * 31 + clave[1]) % tamaño;
    }

    public void insertar(int[] clave, Object valor) {
        int indice = hash(clave);
        List<Entry> lista = tabla.get(indice);

        if (lista == null) {
            lista = new ArrayList<>();
            tabla.set(indice, lista);
        }

        for (Entry entry : lista) {
            if (entry.getClave()[0] == clave[0] && entry.getClave()[1] == clave[1]) {
                entry.valor = valor;
                return;
            }
        }
        lista.add(new Entry(clave, valor));
    }

    public Object buscar(int[] clave) {
        int indice = hash(clave);
        List<Entry> lista = tabla.get(indice);

        if (lista != null) {
            for (Entry entry : lista) {
                if (entry.getClave()[0] == clave[0] && entry.getClave()[1] == clave[1]) {
                    return entry.getValor();
                }
            }
        }

        return null; // Si no se encuentra la coordenada
    }

    public Object eliminar(int[] clave) {
        int indice = hash(clave);
        List<Entry> lista = tabla.get(indice);

        if (lista != null) {
            for (int i = 0; i < lista.size(); i++) {
                Entry entry = lista.get(i);
                if (entry.getClave()[0] == clave[0] && entry.getClave()[1] == clave[1]) {
                    lista.remove(i);
                    return entry.getValor();
                }
            }
        }

        return null; // Si no se encuentra la coordenada
    }

    public static void main(String[] args) {
        Ejercicio6 tabla = new Ejercicio6(10);
        tabla.insertar(new int[]{1, 2}, "valor1");
        tabla.insertar(new int[]{3, 4}, "valor2");

        System.out.println(tabla.buscar(new int[]{1, 2}));
        System.out.println(tabla.buscar(new int[]{3, 4}));

        System.out.println(tabla.eliminar(new int[]{1, 2}));
        System.out.println(tabla.buscar(new int[]{1, 2}));
    }
}
