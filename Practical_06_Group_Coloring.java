public class Practical_06_Group_Coloring {

    final int V = 4; // Number of vertices

    // Check if current color assignment is safe
    boolean isSafe(int v, int graph[][],
                   int color[], int c) {

        for (int i = 0; i < V; i++) {

            if (graph[v][i] == 1 &&
                    c == color[i]) {

                return false;
            }
        }

        return true;
    }

    // Solve graph coloring using backtracking
    boolean graphColoringUtil(int graph[][],
                              int m,
                              int color[],
                              int v) {

        // All vertices are assigned color
        if (v == V)
            return true;

        // Try different colors
        for (int c = 1; c <= m; c++) {

            // Check if safe
            if (isSafe(v, graph, color, c)) {

                color[v] = c;

                // Recur for next vertex
                if (graphColoringUtil(graph,
                        m, color, v + 1))

                    return true;

                // Backtrack
                color[v] = 0;
            }
        }

        return false;
    }

    // Print solution
    void printSolution(int color[]) {

        System.out.println("Assigned Colors:");

        for (int i = 0; i < V; i++) {

            System.out.println(
                    "Vertex " + i +
                            " ---> Color " + color[i]);
        }
    }

    // Main function
    void graphColoring(int graph[][], int m) {

        int color[] = new int[V];

        // Start coloring from vertex 0
        if (!graphColoringUtil(graph,
                m, color, 0)) {

            System.out.println("Solution does not exist");
            return;
        }

        printSolution(color);
    }

    public static void main(String[] args) {

        Practical_06_Group_Coloring gc = new Practical_06_Group_Coloring();

        int graph[][] = {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0}
        };

        int m = 3; // Number of colors

        gc.graphColoring(graph, m);
    }
}