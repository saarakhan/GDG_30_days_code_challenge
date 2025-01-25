import java.util.*;

public class Day_20 {
    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int freshOrg_count = 0;
        Deque<int[]> q = new LinkedList<>();

        // identify the rotten oranges cell & no of fresh oranges
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == 2)
                    q.offer(new int[] { i, j });
                else if (grid[i][j] == 1)
                    freshOrg_count++;
            }
        }

        int minTime = 0;
        int[] dir = { 1, 0, -1, 0, 1 };

        while (!q.isEmpty() && freshOrg_count > 0) {
            minTime++;
            for (int i = q.size(); i > 0; i--) {
                int[] pos = q.poll();

                // checking adj. cells
                for (int j = 0; j < 4; j++) {
                    int x = pos[0] + dir[j];
                    int y = pos[1] + dir[j + 1];

                    // checking if cells are within bound & has fresh Oranges
                    if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                        // making the fresh org. rotten
                        grid[x][y] = 2;
                        freshOrg_count--;
                        q.offer(new int[] { x, y });
                    }
                }
            }
        }
        return freshOrg_count > 0 ? -1 : minTime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("row and col values are ");
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] grid = new int[row][col];
        System.out.println("enter value of grid for" + row + " X " + col);
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                System.out.print("enter " + i + " " + j + " value : ");
                grid[i][j] = sc.nextInt();
            }
            System.out.println();
        }

        System.out.println("printing grid :");
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        int ans = orangesRotting(grid);
        System.out.println(ans);
        sc.close();
    }
}
