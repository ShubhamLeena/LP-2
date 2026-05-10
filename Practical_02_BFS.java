import java.util.*;

public class Practical_02_BFS {

    // Number of vertices
    private int vertices;

    // Adjacency List
    private LinkedList<Integer>[] adjList;

    // Constructor
    Practical_02_BFS(int v) {
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

    // BFS function
    void BFS(int startVertex) {

        // Mark all vertices as not visited
        boolean visited[] = new boolean[vertices];

        // Create queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Mark starting vertex as visited
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {

            // Remove vertex from queue
            int vertex = queue.poll();

            // Print the vertex
            System.out.print(vertex + " ");

            // Visit all adjacent vertices
            for (int adjVertex : adjList[vertex]) {

                if (!visited[adjVertex]) {
                    visited[adjVertex] = true;
                    queue.add(adjVertex);
                }
            }
        }
    }

    public static void main(String[] args) {

        Practical_02_BFS graph = new Practical_02_BFS(5);

        // Adding edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

        System.out.println("Breadth First Search Traversal:");

        // Start BFS from vertex 0
        graph.BFS(0);
    }
}