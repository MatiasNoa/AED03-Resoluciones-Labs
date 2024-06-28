/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphmatrix;
import java.util.ArrayList;

public class GraphMat {

    private int[][] adjacencyMatrix;
    private ArrayList<Integer> vertices;
    private int numVertices;

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public ArrayList<Integer> getVertices() {
        return vertices;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public GraphMat(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
        vertices = new ArrayList<>();
    }

    public void insertVertex(int v) {
        if (!vertices.contains(v)) {
            vertices.add(v);
        }
    }

    public void insertEdge(int v, int z) {
        if (vertices.contains(v) && vertices.contains(z)) {
            adjacencyMatrix[v][z] = 1;
            adjacencyMatrix[z][v] = 1; // Para un grafo no dirigido
        }
    }

    public boolean searchVertex(int v) {
        return vertices.contains(v);
    }

    public boolean searchEdge(int v, int z) {
        if (vertices.contains(v) && vertices.contains(z)) {
            return adjacencyMatrix[v][z] == 1;
        }
        return false;
    }

    public void dfs(int v) {
        boolean[] visited = new boolean[numVertices];
        dfsRecursive(v, visited);
        System.out.println();
    }

    private void dfsRecursive(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[v][i] == 1 && !visited[i]) {
                dfsRecursive(i, visited);
            }
        }
    }

}
