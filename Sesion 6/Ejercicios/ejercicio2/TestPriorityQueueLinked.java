/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

/**
 *
 * @author Asus
 */
public class TestPriorityQueueLinked {
    
    public static void main(String[] args) {
        PriorityQueueLinked<Integer, Integer> priorityQueue = new PriorityQueueLinked<>(3);

        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(10, 1);
        priorityQueue.enqueue(2, 2);
        priorityQueue.enqueue(20, 2);
        priorityQueue.enqueue(30, 0);
        priorityQueue.enqueue(3, 0);

        System.out.println("Cola de prioridades:");
        System.out.println(priorityQueue);

        try {
            int elim = priorityQueue.dequeue();
            System.out.println("Elemento eliminado: " + elim);
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Cola de prioridades después de eliminar un elemento:");
        System.out.println(priorityQueue);

        try {
            int tope = priorityQueue.front();
            System.out.println("Primer elemento de la cola de prioridades: " + tope);
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }

        try {
            int ult = priorityQueue.back();
            System.out.println("Último elemento de la cola de prioridades: " + ult);
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}
