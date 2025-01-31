import java.util.*;

/*
 * In this problem, you are given a maze in which a rat starts at the top-left corner of the maze and needs to find its way to the bottom-right corner. The rat can only move right or down at each step, and some paths are blocked.

Your task is to help the rat find a path from the starting point (0, 0) to the destination (n-1, n-1).
 */
public class Day_26 {
    static int n;
    static int[][] maze;
    static List<String> path = new ArrayList<>();

    public static boolean solve(int x, int y) {
        if (x == n - 1 && y == n - 1) {
            path.add("(" + x + ", " + y + ")");
            return true;
        }

        if (x < n && y < n && maze[x][y] == 1) {
            path.add("(" + x + ", " + y + ")");
            if (solve(x, y + 1))
                return true;
            if (solve(x + 1, y))
                return true;
            path.remove(path.size() - 1);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        maze = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                maze[i][j] = sc.nextInt();

        if (solve(0, 0)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        sc.close();
    }
}