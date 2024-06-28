/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphlink;
import listlinked.*;
import java.util.ArrayList;
/**
 *
 * @author Asus
 */
public class GraphLink<E extends Comparable<E>> {

    protected ListLinked<Vertex<E>> vertexList;

    public GraphLink() {
        vertexList = new ListLinked<Vertex<E>>();
    }

    public void insertVertex(E data) {
        Vertex<E> newVertex = new Vertex<>(data);
        //Verifica si el vertice nuevo no esta en la lista
        if (vertexList.search(newVertex) == -1) {
            vertexList.insertLast(newVertex);
        }
    }

    public void insertEdge(E dataOrig, E dataDest) {
        Vertex<E> verticeOri = null, verticeDest = null;

        //Aux recorre lista
        Node<Vertex<E>> aux = vertexList.getFirst();
        //Se obtienen los vertices
        do {
            if (aux.getData().getData().equals(dataOrig)) {
                verticeOri = aux.getData();
            }
            if (aux.getData().getData().equals(dataDest)) {
                verticeDest = aux.getData();
            }
            aux = aux.getNext();
        } while (aux != null);
        //Verifica que ninguno sea null
        if (verticeOri != null && verticeDest != null) {
            Edge<E> newEdge = new Edge<E>(verticeDest);
            //Verifica si la arista no esta en la lista de adyacencias
            //del vertice de origen
            if (verticeOri.adjacencyList.search(newEdge) == -1) {
                verticeOri.adjacencyList.insertLast(newEdge);
            }
        }
    }

    public boolean searchVertex(Vertex<E> vertex) {
        //Se usa el metodo search de ListLinked que retorna posiciones
        if (vertexList.search(vertex) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean searchEdge(Vertex<E> origin, Vertex<E> destiny) {
        //Se obtiene el vertice de la ListLinked
        Vertex<E> verticeOri = vertexList.getNth(vertexList.search(origin));
        //Auxiliar para recorrer lista de adyacencias
        Node<Edge<E>> aux = verticeOri.adjacencyList.getFirst();
        do {//Se recorre hasta encontrar la arista correcta
            if (aux.getData().getDestinyReference().equals(destiny)) {
                return true;
            }
            aux = aux.getNext();
        } while (aux != null);
        return false;
    }

    public void removeVertex(Vertex<E> vertice) {
        int verticePos = vertexList.search(vertice);
        if (verticePos == -1) {
            System.out.println("El vertice no se encuentra en el grafo.");
        } else {
            // Eliminar las aristas de entrada al vértice eliminado
            Node<Vertex<E>> aux = vertexList.getFirst();
            while (aux != null) {
                removeEdge(aux.getData(), vertice);//Uso el metodo auxiliar removeEdge
                aux = aux.getNext();
            }
            // Eliminar el vértice de la lista de vértices
            vertexList.deleteNth(verticePos);
        }
    }

    public void removeEdge(Vertex<E> origin, Vertex<E> destiny) {
        if (searchEdge(origin, destiny)) {
            //auxiliar para recorrer la lista de adyacencias
            Node<Edge<E>> aux = origin.adjacencyList.getFirst();
            //Mientras el destino de la adyacencia no sea igual a la ingresada
            //por parametro no se para el bucle.
            while (!aux.getData().getDestinyReference().equals(destiny)) {
                aux = aux.getNext();
            }
            //Se remueve la arista de la lista de adyacencia
            origin.adjacencyList.removeNode(aux.getData());
        } else {
            System.out.println("Arista no encontrada en el grafo");
        }
    }

    public void dfs(Vertex<E> verticeOri) {
        StackLink<Vertex<E>> pila = new StackLink<>();
        ListLinked<Vertex<E>> visited = new ListLinked<>();

        pila.push(verticeOri);

        while (!pila.isEmpty()) {
            try {
                //Sacamos el ultimo de la pila
                Vertex<E> current = pila.pop();
                //Verificamos si este no se encuentra visitado
                //Para agregarlo en la lista
                if (visited.search(current) == -1) {
                    System.out.print(current.getData() + ", ");
                    visited.insertLast(current);
                    //auxiliar para recorrer la lista de adyacencia del Vertice actual
                    Node<Edge<E>> aux = current.adjacencyList.getFirst();
                    while (aux != null) {
                        Vertex<E> adjacentVertex = aux.getData().getDestinyReference();
                        //Verificamos si los adyacentes no estan en la lsita
                        //para agregarlo a la pila
                        if (visited.search(adjacentVertex) == -1) {
                            pila.push(adjacentVertex);
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
    
    public void bfs(Vertex<E> verticeOri) {
        QueueLink<Vertex<E>> cola = new QueueLink<>();
        ListLinked<Vertex<E>> visited = new ListLinked<>();

        cola.enqueue(verticeOri);

        while (!cola.isEmpty()) {
            try {
                Vertex<E> current = cola.dequeue();

                if (visited.search(current) == -1) {
                    System.out.print(current.getData() + ", ");
                    visited.insertLast(current);

                    Node<Edge<E>> aux = current.adjacencyList.getFirst();
                    while (aux != null) {
                        Vertex<E> adjacentVertex = aux.getData().getDestinyReference();
                        if (visited.search(adjacentVertex) == -1) {
                            cola.enqueue(adjacentVertex);
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

    public ArrayList<Vertex<E>> bfsPath(Vertex<E> v, Vertex<E> z) {
        QueueLink<Vertex<E>> cola = new QueueLink<>();
        ListLinked<Vertex<E>> visited = new ListLinked<>();
        ListLinked<Vertex<E>> parents = new ListLinked<>();

        cola.enqueue(v);
        visited.insertLast(v);

        while (!cola.isEmpty()) {
            try {
                Vertex<E> current = cola.dequeue();

                if (current.equals(z)) {
                    // Reconstruir el camino desde z hasta v
                    return reconstructPath(v, z, parents);
                }

                Node<Edge<E>> aux = current.adjacencyList.getFirst();
                while (aux != null) {
                    Vertex<E> adjacentVertex = aux.getData().getDestinyReference();
                    if (visited.search(adjacentVertex) == -1) {
                        cola.enqueue(adjacentVertex);
                        visited.insertLast(adjacentVertex);
                        parents.insertLast(current); // Guardar el padre de adjacentVertex
                    }
                    aux = aux.getNext();
                }
            } catch (ExceptionIsEmpty e) {
                e.printStackTrace();
            }
        }

        // Si no se encuentra ningún camino, devolver null
        return null;
    }

    private ArrayList<Vertex<E>> reconstructPath(Vertex<E> v, Vertex<E> z, ListLinked<Vertex<E>> parents) {
        ArrayList<Vertex<E>> path = new ArrayList<>();
        Vertex<E> current = z;
        while (!current.equals(v)) {
            path.add(0, current); // Agregar al principio para mantener el orden correcto
            current = getParent(current, parents);
        }
        path.add(0, v); // Agregar el vértice inicial v al principio del camino
        return path;
    }

    private Vertex<E> getParent(Vertex<E> vertex, ListLinked<Vertex<E>> parents) {
        Node<Vertex<E>> aux = parents.getFirst();
        while (aux != null) {
            if (aux.getData().adjacencyList.search(new Edge<>(vertex)) != -1) {
                return aux.getData();
            }
            aux = aux.getNext();
        }
        return null;
    }
    
    public void insertEdgeWeight(E v, E z, int w) {
        Vertex<E> verticeOri = null, verticeDest = null;

        // Buscar y asignar el vértice de origen y destino
        Node<Vertex<E>> aux = vertexList.getFirst();
        while (aux != null && (verticeOri == null || verticeDest == null)) {
            if (aux.getData().getData().equals(v)) {
                verticeOri = aux.getData();
            }
            if (aux.getData().getData().equals(z)) {
                verticeDest = aux.getData();
            }
            aux = aux.getNext();
        }

        // Si alguno de los vértices no existe, no se puede insertar la arista
        if (verticeOri != null && verticeDest != null) {
            Edge<E> newEdge = new Edge<>(verticeDest, w);

            // Verificar si la arista no está en la lista de adyacencias del vértice de origen
            if (verticeOri.adjacencyList.search(newEdge) == -1) {
                verticeOri.adjacencyList.insertLast(newEdge);
            }

            // Para un grafo no dirigido, también se debe agregar la arista inversa
            Edge<E> reverseEdge = new Edge<>(verticeOri, w);
            if (verticeDest.adjacencyList.search(reverseEdge) == -1) {
                verticeDest.adjacencyList.insertLast(reverseEdge);
            }
        } else {
            System.out.println("No se puede insertar la arista. Vértices no encontrados.");
        }
    }
   
    @Override
    public String toString() {
        return this.vertexList.toString();
    }
}
