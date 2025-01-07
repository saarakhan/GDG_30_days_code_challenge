import java.io.*;
import java.util.*;

public class Solution {
    // O(n) Kadanes algo
    public static int largestSum(int[] arr, int n) {
        int sum = arr[0], res = arr[0];
        
        for(int i=1; i<n; i++) {
                sum = Math.max(sum + arr[i], arr[i]);
                res = Math.max(sum ,res);
        }
        return res;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int sum = largestSum(arr, n);
        
        if(sum >= 0) {
            System.out.println(sum);
        } else {
            System.out.println("Invalid Input");
        }
        
        
    }
}