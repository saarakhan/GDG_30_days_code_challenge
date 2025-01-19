import java.util.*;

//assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.
public class Day_14 {

    public static boolean canWePlace(int[] stalls, int dist, int cows) {
        int n = stalls.length;
        int cntCows = 1;
        int last = stalls[0];
        for (int i = 1; i < n; i++) {
            if (stalls[i] - last >= dist) {
                cntCows++;
                last = stalls[i];
            }
            if (cntCows >= cows)
                return true;
        }
        return false;
    }

    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;

        Arrays.sort(stalls);

        int low = 1, high = stalls[n - 1] - stalls[0];

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(stalls, mid, k) == true) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return high;
    }

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        int ans = aggressiveCows(arr, k);
        System.out.println(ans);
        sc.close();
    }
}

/*
 * INPUT :
 * 5
 * 1 2 4 8 9
 * 3
 * OUTPUT : 3
 */
