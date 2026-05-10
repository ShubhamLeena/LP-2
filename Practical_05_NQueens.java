public class Practical_05_NQueens {

    final int N = 4;

    // Function to print solution
    void printSolution(int board[][]) {

        System.out.println("Solution:");

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }

    // Check if queen can be placed
    boolean isSafe(int board[][], int row, int col) {

        int i, j;

        // Check left side row
        for (i = 0; i < col; i++) {

            if (board[row][i] == 1)
                return false;
        }

        // Check upper diagonal
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {

            if (board[i][j] == 1)
                return false;
        }

        // Check lower diagonal
        for (i = row, j = col; j >= 0 && i < N; i++, j--) {

            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    // Solve N Queen using Backtracking
    boolean solveNQUtil(int board[][], int col) {

        // All queens placed
        if (col >= N)
            return true;

        // Try each row
        for (int i = 0; i < N; i++) {

            if (isSafe(board, i, col)) {

                // Place queen
                board[i][col] = 1;

                // Recur for next column
                if (solveNQUtil(board, col + 1))
                    return true;

                // Backtrack
                board[i][col] = 0;
            }
        }

        return false;
    }

    // Main function
    void solveNQ() {

        int board[][] = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        if (!solveNQUtil(board, 0)) {

            System.out.println("No Solution");
            return;
        }

        printSolution(board);
    }

    public static void main(String[] args) {

        Practical_05_NQueens queen = new Practical_05_NQueens();

        queen.solveNQ();
    }
}