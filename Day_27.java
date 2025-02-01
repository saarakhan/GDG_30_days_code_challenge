import java.util.*;

/*Classic N-Queen Problem -> Recursion & Backtracking */

public class Day_27 {

    static void solveNQueens(char[][] board, int row, List<int[][]> solutions) {
        // If all rows are filled, add the board configuration to the solution list
        if (row == board.length) {
            solutions.add(constructMatrix(board));
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) { // Check if the position is safe
                board[row][col] = 'Q'; // Place the queen
                solveNQueens(board, row + 1, solutions); // Move to the next row
                board[row][col] = '.'; // Backtrack and remove the queen
            }
        }
    }

    static boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    static int[][] constructMatrix(char[][] board) {
        int n = board.length;
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Queen as 1, empty as 0
                matrix[i][j] = (board[i][j] == 'Q') ? 1 : 0;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] board = new char[n][n];
        for (char[] row : board)
            Arrays.fill(row, '.');

        List<int[][]> solutions = new ArrayList<>();
        solveNQueens(board, 0, solutions);

        if (solutions.isEmpty()) {
            System.out.println("NO");
        } else {
            for (int[][] solution : solutions) {
                for (int[] row : solution) {
                    for (int num : row) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }
        sc.close();
    }
}
