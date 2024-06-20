class Coord implements Comparable<Coord> {
    public final int x;
    public final int y;
    public String valor;

    public Coord(int x, int y, String valor) {
        this.x = x;
        this.y = y;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ") -> "+valor;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public int compareTo(Coord other) {
        // Comparación por coordenada x primero
        if (this.x != other.x) {
            return Integer.compare(this.x, other.x);
        }
        // Si son iguales en x, comparar por coordenada y
        return Integer.compare(this.y, other.y);
    }
}
