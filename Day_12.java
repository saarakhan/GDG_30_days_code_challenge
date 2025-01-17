import java.util.*;

public class Day_12 {
    /*
     * Given an array arr of positive integers sorted in a strictly increasing
     * order, and an integer k.
     * 
     * Return the kth positive integer that is missing from this array.
     * 
     * Input Format
     * 
     * The first line contains an integer n — the size of the array.
     * The second line contains n integers — the elements of the sorted array arr.
     * The third line contains an integer k.
     * Constraints
     * 
     * 1 ≤ n ≤ 1000
     * 1 ≤ arr[i] ≤ 10^4 with arr[i] < arr[i+1]
     * 1 ≤ k ≤ 10^4
     * Output Format
     * 
     * Print a single integer — the kth missing positive number.
     */

    public static int kthMissing(int[] arr, int n, int k) {
        // using index to check whether the number exists or not
        // i - index, j - current value to compare
        int missedCount = 0, i = 0, j = 1;

        while (true) {
            if (i < n && arr[i] == j)
                i++; // if index and current value equals that mean exists
            else {
                missedCount++; // increase the counter showing missed value
                if (missedCount == k)
                    return j;// the kth missedValue reach than return
            }
            j++; // next number
        }
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
        System.out.println(kthMissing(arr, n, k));
        sc.close();
    }
}