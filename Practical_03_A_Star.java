import java.util.*;

class Node {
    int vertex;
    int cost;

    Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }
}

public class Practical_03_A_Star {

    static final int V = 6;

    // Heuristic values (estimated distance to goal)
    static int heuristic[] = {10, 8, 5, 7, 3, 0};

    // A* Algorithm
    static void aStar(int graph[][], int start, int goal) {

        PriorityQueue<Node> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));

        boolean visited[] = new boolean[V];

        pq.add(new Node(start, heuristic[start]));

        System.out.println("Path Traversal:");

        while (!pq.isEmpty()) {

            Node current = pq.poll();
            int u = current.vertex;

            if (visited[u])
                continue;

            visited[u] = true;

            System.out.print(u + " ");

            // Goal reached
            if (u == goal) {
                System.out.println("\nGoal Reached!");
                return;
            }

            // Visit neighbors
            for (int v = 0; v < V; v++) {

                if (graph[u][v] > 0 && !visited[v]) {

                    int fCost = graph[u][v] + heuristic[v];

                    pq.add(new Node(v, fCost));
                }
            }
        }
    }

    public static void main(String[] args) {

        int graph[][] = {
                {0, 1, 4, 0, 0, 0},
                {1, 0, 2, 5, 12, 0},
                {4, 2, 0, 2, 0, 0},
                {0, 5, 2, 0, 3, 1},
                {0, 12, 0, 3, 0, 2},
                {0, 0, 0, 1, 2, 0}
        };

        int start = 0;
        int goal = 5;

        aStar(graph, start, goal);
    }
}