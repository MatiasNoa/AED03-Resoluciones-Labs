package Actividades.actividad2;

public class Test{
    public static void main(String[] args) throws ExceptionIsEmpty{
        Queue<Integer> colaInteger = new QueueLink<Integer>();
        colaInteger.enqueue(6);
        colaInteger.enqueue(7);
        colaInteger.enqueue(8);
        colaInteger.enqueue(9);
        colaInteger.enqueue(10);
        
        System.out.println(colaInteger);
        System.out.println("Desencolar: " + colaInteger.dequeue());
        System.out.println(colaInteger);
        System.out.println("Back: " + colaInteger.back() + "\nFront: " + colaInteger.front());
        System.out.println("Desencolar: " + colaInteger.dequeue());
        System.out.println(colaInteger);

        System.out.println("\n\n");
        //===================================================================
        Queue<String> colaString = new QueueLink<String>();
        colaString.enqueue("Rojo");
        colaString.enqueue("Azul");
        colaString.enqueue("Verde");
        colaString.enqueue("Morado");
        colaString.enqueue("Blanco");
        
        System.out.println(colaString);
        System.out.println("Desencolar: " + colaString.dequeue());
        System.out.println(colaString);
        System.out.println("Back: " + colaString.back() + "\nFront: " + colaString.front());
        System.out.println("Desencolar: " + colaString.dequeue());
        System.out.println(colaString);
    }
}
