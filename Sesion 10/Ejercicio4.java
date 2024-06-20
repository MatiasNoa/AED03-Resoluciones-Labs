public class Ejercicio4{
    public static void main(String[] args) {
        TablaHashFrecuencia tabla = new TablaHashFrecuencia();
        tabla.insert("hola hola mundo adios mundo hola");
        System.out.println(tabla);
        System.out.println("hola: "+tabla.getFrecuencia("hola"));
        System.out.println("mundo: "+tabla.getFrecuencia("mundo"));
        System.out.println("adios: "+tabla.getFrecuencia("adios"));
    }
}