/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphlink;
import java.util.ArrayList;
/**
 *
 * @author Asus
 */
public class Test {

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
        grafoNumeros.dfs(verticeOrigen);
        System.out.println("Recorrido BFS");
        grafoNumeros.bfs(verticeOrigen);
        
//        Vertex<Integer> verticeOrigen = grafoNumeros.vertexList.getNth(0); // Vértice 1
//        Vertex<Integer> verticeDestino = grafoNumeros.vertexList.getNth(3); // Vértice 4
//        
//        // Calcular el camino entre vértices usando bfsPath
//        ArrayList<Vertex<Integer>> camino = grafoNumeros.bfsPath(verticeOrigen, verticeDestino);
//
//        // Imprimir el camino encontrado
//        if (camino != null) {
//            System.out.print("Camino: ");
//            for (Vertex<Integer> vertex : camino) {
//                System.out.print(vertex.getData() + " ");
//            }
//            System.out.println();
//        } else {
//            System.out.println("No existe un camino entre los vertices");
//        }
        
    }
}
