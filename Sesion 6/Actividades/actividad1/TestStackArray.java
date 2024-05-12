package Actividades.actividad1;

public class TestStackArray {
    public static void main(String[] args) {
        StackArray<Integer> pila = new StackArray<Integer>(5);

        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);
        pila.push(6);

        System.out.println("Contenido de la pila: " + pila.toString());
        
        try {
            System.out.println("Elemento eliminado: " + pila.pop());
        } catch (ExceptionIsEmpty e) {
            e.printStackTrace();
        }
        
        System.out.println("Contenido de la pila: " + pila.toString());        
        
        try {
            System.out.println("Elemento en la cima: " + pila.top()); 
        } catch (ExceptionIsEmpty e) {
            e.printStackTrace();
        }
        
        System.out.println("La pila está vacía?: " + pila.isEmpty());
        System.out.println("La pila está llena?: " + pila.isFull());
    }
}
