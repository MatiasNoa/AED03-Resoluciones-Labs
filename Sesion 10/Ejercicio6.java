import java.util.Arrays;

public class Ejercicio6{
    public static void main(String[] args) {
        TablaHashCoordenadas tabla = new TablaHashCoordenadas(10);

        int[] coords1 = {2, 3};
        int[] coords2 = {5, 7};
        int[] coords3 = {1, 9};

        tabla.insert(coords1, new Coord(2, 3, "coord1"));
        tabla.insert(coords2, new Coord(5, 7, "coord2"));
        tabla.insert(coords3, new Coord(1, 9, "coord3"));

        System.out.println("Tabla Hash de Coordenadas:");
        System.out.println(tabla);

        int[] coord4 = {5, 7};
        System.out.println("\nValor encontrado en las coordenadas " + Arrays.toString(coord4) + ": " + tabla.search(coord4));

        int[] deleteCoords = {2, 3};
        tabla.delete(deleteCoords);
        System.out.println("\nTabla Hash después de eliminar las coordenadas " + Arrays.toString(deleteCoords) + ":");
        System.out.println(tabla);
    }
}