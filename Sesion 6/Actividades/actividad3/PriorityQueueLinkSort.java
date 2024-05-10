package Actividades.actividad3;

public class PriorityQueueLinkSort<E, P extends Comparable<P>> implements PriorityQueue<E, P> {
    class EntryNode {
        E data;
        P priority;
        
        EntryNode(E data, P priority) {
            this.data = data;
            this.priority = priority;
        }
        @Override
        public String toString() {
            return ""+this.data+"("+this.priority+")";
        }
    }

    private Node<EntryNode> first;
    private Node<EntryNode> last;

    public PriorityQueueLinkSort() {
        this.first = null;
        this.last = null;
    }

    public void enqueue(E x, P prio) {
        EntryNode entry = new EntryNode(x, prio);
        Node<EntryNode> newNode = new Node<>(entry);
        //Si la cola esta vacia o la prioridad es mayor al primer elemento
        //se inserta el elemento en la primera posicion
        if(isEmpty() || prio.compareTo(first.getData().priority) > 0){
            newNode.setNext(first);
            first = newNode;
        }else{
            Node<EntryNode> aux = first;
            //Se recorre hasta que el siguiente del nodo al que apunta aux sea menor o igual prioritario
            while (aux.getNext() != null && prio.compareTo(aux.getNext().getData().priority) <= 0) {
                aux = aux.getNext();
            }
            newNode.setNext(aux.getNext());
            aux.setNext(newNode);
        }
        if (last == null) {
            last = newNode;
        }
    }

    public E dequeue() throws ExceptionIsEmpty{
        try{
            if(isEmpty()){
                throw new ExceptionIsEmpty("La cola esta vacia.");
            }
            E aux = first.getData().data;
            first = first.getNext();
            if(first == null){
                last = null;
            }
            return aux;
        }catch(ExceptionIsEmpty e){
            System.out.println("La cola esta vacia.");
            return null;
        }
    }

    public E back() throws ExceptionIsEmpty{
        try{
            if(isEmpty()){
                throw new ExceptionIsEmpty("La cola esta vacia.");
            }else{
                Node<EntryNode> aux = first;
                while(aux.getNext() != null){
                    aux = aux.getNext();
                }
                return aux.getData().data;
            }
        }catch(ExceptionIsEmpty e){
            System.out.println("La cola esta vacia.");
            return null;
        }
    }

    public E front() throws ExceptionIsEmpty{
        try{
            if (isEmpty()) {
                throw new ExceptionIsEmpty("La cola esta vacia.");
            }
            return first.getData().data;
        }catch(ExceptionIsEmpty e){
            System.out.println("La cola esta vacia.");
            return null;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String toString(){
        String message = "";
        if(isEmpty()){
            message = "La cola esta vacia.";
        }else{
            Node<EntryNode> aux = first;
            message += aux;
            while(aux.getNext() != null){
                message += " -> ";
                message += aux.getNext();
                aux = aux.getNext();
            }
        }
        return message;
    }
}
