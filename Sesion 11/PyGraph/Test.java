public class Test{
    public static void main(String[] args) {
        GraphLink<Integer> grafoNumeros = new GraphLink<>();
        //Insertamos Vertices
        grafoNumeros.insertVertex(1);
        grafoNumeros.insertVertex(2);
        grafoNumeros.insertVertex(3);
        grafoNumeros.insertVertex(4);

        //Insertamos Aristas
        grafoNumeros.insertEdge(1, 2);
        grafoNumeros.insertEdge(1, 3);
        grafoNumeros.insertEdge(3, 2);
        grafoNumeros.insertEdge(3, 4);
        grafoNumeros.insertEdge(4, 1);

        System.out.println(grafoNumeros);

        //Obtenemos uno de los vertices guardados en vertexList
        Vertex<Integer> verticeOrigen = grafoNumeros.vertexList.getNth(0);
        System.out.println("Recorrido DFS");
        grafoNumeros.depthFirstSearch(verticeOrigen);
    }
}