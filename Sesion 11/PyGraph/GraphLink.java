public class GraphLink <E extends Comparable<E>>{
    protected ListLinked<Vertex<E>> vertexList;

    public GraphLink(){
        vertexList = new ListLinked<Vertex<E>>();
    }
    
    public void insertVertex(E data){
        Vertex<E> newVertex = new Vertex<>(data);
        //Verifica si el vertice nuevo no esta en la lista
        if (vertexList.search(newVertex) == -1) {
            vertexList.insertLast(newVertex);
        }
    }

    public void insertEdge(E dataOrig, E dataDest) {
        Vertex<E> originVertex = null, destinyVertex = null;

        //Aux recorre lista
        Node<Vertex<E>> aux = vertexList.getFirst();
        //Se obtienen los vertices
        do{
            if(aux.getData().getData().equals(dataOrig)){
                originVertex = aux.getData();
            }
            if(aux.getData().getData().equals(dataDest)){
                destinyVertex = aux.getData();
            }
            aux = aux.getNext();
        }while(aux != null);
        //Verifica que ninguno sea null
        if(originVertex != null && destinyVertex != null){
            Edge<E> newEdge = new Edge<E>(destinyVertex);
            //Verifica si la arista no esta en la lista de adyacencias
            //del vertice de origen
            if(originVertex.adjacencyList.search(newEdge) == -1){
                originVertex.adjacencyList.insertLast(newEdge);
            }
        }
    }

    public boolean searchVertex(Vertex<E> vertex){
        //Se usa el metodo search de ListLinked que retorna posiciones
        if(vertexList.search(vertex) == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean searchEdge(Vertex<E> origin, Vertex<E> destiny){
        //Se obtiene el vertice de la ListLinked
        Vertex<E> originVertex = vertexList.getNth(vertexList.search(origin));
        //Auxiliar para recorrer lista de adyacencias
        Node<Edge<E>> aux = originVertex.adjacencyList.getFirst();
        do{//Se recorre hasta encontrar la arista correcta
            if(aux.getData().getDestinyReference().equals(destiny)){
                return true;
            }
            aux = aux.getNext();
        }while(aux != null);
        return false;
    }

    public void removeVertex(Vertex<E> vertex){
        int vertexPosition = vertexList.search(vertex);
        if(vertexPosition == -1){
            System.out.println("El vertice no se encuentra en el grafo.");
        } else {
            // Eliminar las aristas de entrada al vértice eliminado
            Node<Vertex<E>> aux = vertexList.getFirst();
            while(aux != null){
                removeEdge(aux.getData(), vertex);//Uso el metodo auxiliar removeEdge
                aux = aux.getNext();
            }
            // Eliminar el vértice de la lista de vértices
            vertexList.deleteNth(vertexPosition);
        }
    }

    public void removeEdge(Vertex<E> origin, Vertex<E> destiny){
        if(searchEdge(origin, destiny)){
            //auxiliar para recorrer la lista de adyacencias
            Node<Edge<E>> aux = origin.adjacencyList.getFirst();
            //Mientras el destino de la adyacencia no sea igual a la ingresada
            //por parametro no se para el bucle.
            while(!aux.getData().getDestinyReference().equals(destiny)){
                aux = aux.getNext();
            }
            //Se remueve la arista de la lista de adyacencia
            origin.adjacencyList.removeNode(aux.getData());
        }else{
            System.out.println("Arista no encontrada en el grafo");
        }
    }

    public void depthFirstSearch(Vertex<E> originVertex){
        StackLink<Vertex<E>> stack = new StackLink<>();
        ListLinked<Vertex<E>> visited = new ListLinked<>();

        stack.push(originVertex);

        while (!stack.isEmpty()) {
            try{
                //Sacamos el ultimo de la pila
                Vertex<E> current = stack.pop();
                //Verificamos si este no se encuentra visitado
                //Para agregarlo en la lista
                if (visited.search(current) == -1) {
                    System.out.print(current.getData()+", ");
                    visited.insertLast(current);
                    //auxiliar para recorrer la lista de adyacencia del Vertice actual
                    Node<Edge<E>> aux = current.adjacencyList.getFirst();
                    while (aux != null) {
                        Vertex<E> adjacentVertex = aux.getData().getDestinyReference();
                        //Verificamos si los adyacentes no estan en la lsita
                        //para agregarlo a la pila
                        if (visited.search(adjacentVertex) == -1) {
                            stack.push(adjacentVertex);
                        }
                        aux = aux.getNext();
                    }
                }
            } catch (ExceptionIsEmpty e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    @Override
    public String toString(){
        return this.vertexList.toString();
    }
}
