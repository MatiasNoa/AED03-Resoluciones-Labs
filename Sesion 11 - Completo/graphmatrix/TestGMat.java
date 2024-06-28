/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphmatrix;

/**
 *
 * @author Asus
 */
public class TestGMat {
    public static void main(String[] args) {
        GraphMat graph = new GraphMat(5);

        // Insertar vértices
        graph.insertVertex(0);
        graph.insertVertex(1);
        graph.insertVertex(2);
        graph.insertVertex(3);
        graph.insertVertex(4);

        // Insertar aristas
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 4);
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 3);
        graph.insertEdge(1, 4);
        graph.insertEdge(2, 3);
        graph.insertEdge(3, 4);

        // Mostrar la matriz de adyacencia
        System.out.println("Matriz de Adyacencia:");
        for (int i = 0; i < graph.getNumVertices(); i++) {
            for (int j = 0; j < graph.getNumVertices(); j++) {
                System.out.print(graph.getAdjacencyMatrix()[i][j] + " ");
            }
            System.out.println();
        }

        // Buscar vértice y arista
        System.out.println("Buscar vértice 2: " + graph.searchVertex(2));
        System.out.println("Buscar arista entre 1 y 3: " + graph.searchEdge(1, 3));

        // Recorrido DFS desde el vértice 0
        System.out.println("Recorrido DFS desde el vértice 0:");
        graph.dfs(0);
    }
}
