package pygraph;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedMultigraph;

public class JGrpahTest {
    public static void main(String[] args) {
        Graph<String, DefaultWeightedEdge> graph = new DirectedWeightedMultigraph<>(DefaultWeightedEdge.class);

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.setEdgeWeight(graph.addEdge("A", "B"), 1.0);
        graph.setEdgeWeight(graph.addEdge("A", "C"), 2.0);
        graph.setEdgeWeight(graph.addEdge("B", "D"), 1.0);
        graph.setEdgeWeight(graph.addEdge("C", "D"), 3.0);
        graph.setEdgeWeight(graph.addEdge("C", "E"), 2.0);
        graph.setEdgeWeight(graph.addEdge("D", "E"), 1.0);

        // Mostrar los vértices
        System.out.println("Vértices del grafo: " + graph.vertexSet());

        // Mostrar las aristas con sus pesos
        System.out.println("Aristas del grafo: ");
        for (DefaultWeightedEdge edge : graph.edgeSet()) {
            System.out.println(graph.getEdgeSource(edge) + " -> " +
                               graph.getEdgeTarget(edge) + " : " + graph.getEdgeWeight(edge));
        }

        // Encontrar el camino más corto desde A hasta E usando el algoritmo de Dijkstra
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraAlg = new DijkstraShortestPath<>(graph);
        GraphPath<String, DefaultWeightedEdge> path = dijkstraAlg.getPath("A", "E");

        // Mostrar el camino más corto y su peso total
        if (path != null) {
            System.out.println("Camino más corto de A a E: " + path.getVertexList());
            System.out.println("Peso total del camino más corto: " + path.getWeight());
        } else {
            System.out.println("No hay camino de A a E.");
        }
    }
}


