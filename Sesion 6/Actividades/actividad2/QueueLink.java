package Actividades.actividad2;

public class QueueLink<E> implements Queue<E>{
    private Node<E> first;
    private Node<E> last;

    public QueueLink(){
        this.first = null;
        this.last = null;
    }

    public void enqueue(E x){
        Node<E> aux = new Node<E>(x);
        if(isEmpty()){
            first = aux;
            last = aux;
            return;
        }else if(last == first){
            first.setNext(aux);
            last = aux;
            return;
        }else{
            last.setNext(aux);
            last = aux;
            return;
        }
    }

    public E dequeue() throws ExceptionIsEmpty{
        try{
            if(isEmpty()){
                throw new ExceptionIsEmpty();
            }
            E data = first.getData();
            first = first.getNext();
            if(first == null){
                last = null;
            }
            return data; 
        }catch(ExceptionIsEmpty e){
            e.printStackTrace();
            return null;
        }
        
    }
    
    public E back() throws ExceptionIsEmpty{
        try{
            if(isEmpty()){
                throw new ExceptionIsEmpty();
            }else{
                return last.getData();
            }
        }catch(ExceptionIsEmpty e){
            e.printStackTrace();
            return null;
        }
        
    }

    public E front() throws ExceptionIsEmpty{
        try{
            if(isEmpty()){
                throw new ExceptionIsEmpty();
            }
            return first.getData();
        }catch(ExceptionIsEmpty e){
            e.printStackTrace();
            return null;
        }
        
    }

    public boolean isEmpty(){
        return first == null;
    }

    public String toString(){
        String message = "";
        if(isEmpty()){
            message = "La cola esta vacia.";
        }else{
            Node<E> aux = first;
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
