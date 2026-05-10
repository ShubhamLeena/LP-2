import java.util.*;

public class Practical_01_DFS {

    // Number of vertices
    private int vertices;

    // Adjacency list
    private LinkedList<Integer>[] adjList;

    // Constructor
    Practical_01_DFS(int v) {
        vertices = v;
        adjList = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Add edge for undirected graph
    void addEdge(int v, int w) {
        adjList[v].add(w);
        adjList[w].add(v);
    }

    // DFS function
    void DFS(int vertex, boolean visited[]) {

        // Mark current node as visited
        visited[vertex] = true;

        // Print the visited vertex
        System.out.print(vertex + " ");

        // Visit all adjacent vertices
        for (int adjVertex : adjList[vertex]) {
            if (!visited[adjVertex]) {
                DFS(adjVertex, visited);
            }
        }
    }

    public static void main(String[] args) {

        Practical_01_DFS graph = new Practical_01_DFS(5);

        // Adding edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

        boolean visited[] = new boolean[5];

        System.out.println("Depth First Search Traversal:");

        // Start DFS from vertex 0
        graph.DFS(0, visited);
    }
}