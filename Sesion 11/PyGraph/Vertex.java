public class Vertex<E extends Comparable<E>>{
    private E data;
    protected ListLinked<Edge<E>> adjacencyList;

    public Vertex(E data){
        this.data = data;
        adjacencyList = new ListLinked<Edge<E>>();
    }

    public E getData() {
        return data;
    }

    public boolean equals(Object o){
        if(o instanceof Vertex<?>){
            Vertex<E> v = (Vertex<E>) o;
            return this.data.equals(v.data);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.data+" --> "+ this.adjacencyList.toString()+"\n";
    }
}

