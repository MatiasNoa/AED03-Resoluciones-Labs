public class NodePila <T>{
    private T data;
    private NodePila<T> next;

    public NodePila(T data){
        this.data = data;
        this.next = null;
    }
    public NodePila(T data, NodePila<T> next){
        this.data = data;
        this.next = next;
    }
    public T getData(){return data;}
    public NodePila<T> getNext(){return next;}
    public void setData(T data){this.data = data;}
    public void setNext(NodePila<T> next){this.next = next;}

    @Override
    public String toString() {
        return ""+this.data;
    }
}
