public class TablaHashFrecuencia {
    private class NodoFrecuencia implements Comparable<NodoFrecuencia> {
        int frecuencia;
        String texto;

        public NodoFrecuencia(String texto) {
            this.frecuencia = 1;
            this.texto = texto;
        }

        public int getFrecuencia() {
            return frecuencia;
        }

        public String getTexto() {
            return texto;
        }

        public void setFrecuencia(int frecuencia) {
            this.frecuencia = frecuencia;
        }

        public void setTexto(String texto) {
            this.texto = texto;
        }

        public int compareTo(NodoFrecuencia other) {
            int frecuenciaComparison = Integer.compare(this.frecuencia, other.frecuencia);
            if (frecuenciaComparison != 0) {
                return frecuenciaComparison;
            }
            return this.texto.compareTo(other.texto);
        }

        @Override
        public String toString() {
            return texto;
        }
    }

    private HashA<NodoFrecuencia> tablaFrecuencias;

    public TablaHashFrecuencia() {
        this.tablaFrecuencias = new HashA<>(7); // Tamaño inicial de la tabla hash
    }

    public void insert(String texto) {
        String[] palabras = texto.split("\\s+"); // Divide el texto por espacios en blanco

        for (String palabra : palabras) {
            NodoFrecuencia nodo = new NodoFrecuencia(palabra);
            NodoFrecuencia existente = tablaFrecuencias.search(palabra.hashCode());
            if (existente != null) {
                existente.setFrecuencia(existente.getFrecuencia() + 1);
            } else {
                tablaFrecuencias.insert(palabra.hashCode(), nodo);
            }
        }
    }

    public int getFrecuencia(String palabra) {
        NodoFrecuencia nodo = tablaFrecuencias.search(palabra.hashCode());
        if (nodo != null) {
            return nodo.getFrecuencia();
        }
        return 0;
    }

    @Override
    public String toString() {
        return tablaFrecuencias.toString();
    }
}
