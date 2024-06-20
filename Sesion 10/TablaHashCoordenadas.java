import java.util.Arrays;

public class TablaHashCoordenadas {
    private HashC<Coord> tablaCoordenadas;

    public TablaHashCoordenadas(int size) {
        this.tablaCoordenadas = new HashC<>(size);
    }

    public void insert(int[] coordenadas, Coord valor) {
        int key = Arrays.hashCode(coordenadas);
        tablaCoordenadas.insert(key, valor);
    }

    public String search(int[] coordenadas) {
        int key = Arrays.hashCode(coordenadas);
        Coord coord = tablaCoordenadas.search(key);
        return coord.getValor();
    }

    public void delete(int[] coordenadas) {
        int key = Arrays.hashCode(coordenadas);
        tablaCoordenadas.delete(key);
    }

    public String toString() {
        return tablaCoordenadas.toString();
    }
}