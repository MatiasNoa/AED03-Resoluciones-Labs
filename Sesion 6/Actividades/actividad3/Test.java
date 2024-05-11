package Actividades.actividad3;

public class Test{
    public static void main(String[] args) throws ExceptionIsEmpty{
        PriorityQueue<String, Integer> colaString = new PriorityQueueLinkSort<String, Integer>();
        System.out.println(colaString.back());
        colaString.enqueue("Perro",3);
        colaString.enqueue("Gato",1);
        colaString.enqueue("Loro",2);
        colaString.enqueue("Cuy",2);
        colaString.enqueue("Ballena",5);
        
        System.out.println(colaString);
        System.out.println("Desencolar: " + colaString.dequeue());
        System.out.println(colaString);
        System.out.println("Back: " + colaString.back() + "\nFront: " + colaString.front());
        System.out.println("Desencolar: " + colaString.dequeue());
        System.out.println(colaString);

        System.out.println("\n\n");
        //===================================================================
        PriorityQueue<String, Double> colaString2 = new PriorityQueueLinkSort<String, Double>();
        colaString2.enqueue("Rojo", 1.0);
        colaString2.enqueue("Azul", 1.3);
        colaString2.enqueue("Verde", 4.9);
        colaString2.enqueue("Morado", 5.0);
        colaString2.enqueue("Blanco",5.001);
        
        System.out.println(colaString2);
        System.out.println("Desencolar: " + colaString2.dequeue());
        System.out.println(colaString2);
        System.out.println("Back: " + colaString2.back() + "\nFront: " + colaString2.front());
        System.out.println("Desencolar: " + colaString2.dequeue());
        System.out.println(colaString2);
    }
}
