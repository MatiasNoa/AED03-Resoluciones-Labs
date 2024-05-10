/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

/**
 *
 * @author Asus
 */
public class PriorityQueueLinked<E, P> implements PriorityQueue<E, P> {
    
    private QueueLink[] colas;
    private int prioridades;
    
    public PriorityQueueLinked(int prioridades) {
        this.prioridades = prioridades;
        this.colas = new QueueLink[prioridades];
        for (int i = 0; i < prioridades; i++) {
            colas[i] = new QueueLink<>();
        }
    }

    @Override
    public void enqueue(E x, P pr) {
        int indice = (int) pr;
        if (indice < 0 || indice >= prioridades) {
            System.out.println("Prioridad inválida");
            return;
        }
        colas[indice].enqueue(x);
    }

    public E dequeue() throws ExceptionIsEmpty {
        for (int i = 0; i < prioridades; i++) {
            if (!colas[i].isEmpty()) {
                return (E) colas[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("La cola está vacía");
    }

    public E front() throws ExceptionIsEmpty {
        for (int i = 0; i < prioridades; i++) {
            if (!colas[i].isEmpty()) {
                return (E) colas[i].front();
            }
        }
        throw new ExceptionIsEmpty("La cola está vacía");
    }

    public E back() throws ExceptionIsEmpty {
        for (int i = prioridades - 1; i >= 0; i--) {
            if (!colas[i].isEmpty()) {
                return (E) colas[i].back();
            }
        }
        throw new ExceptionIsEmpty("La cola está vacía");
    }

    public boolean isEmpty() {
        for (int i = 0; i < prioridades; i++) {
            if (!colas[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = prioridades - 1; i >= 0; i--) {
            sb.append("Cola de Prioridades ").append(i).append(": ").append(colas[i]).append("\n");
        }
        return sb.toString();
    }

}
