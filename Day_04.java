import java.io.*;
import java.util.*;

public class Day_04 {
    /*
     * given a permutation of 1,2, …, n, generate the next permutation in
     * lexicographic(dictionary) order. 
     * For example, for 2 3 1 4 the answer is 2 3 4 1.
     *  Assume that an answer always exists.
     * 
     * also N<=1000
     */

     //! next permutation is smallest number but greater than current number
    //  ! 3 1 2 , next permutation will be : 3 2 1

    /* 
     * STEP 1 : find the point from right where the current element is less than the next element : ex. 2 3 4 5 1 , 4 is the point where 4 < 5
     * STEP 2 : swap the point with the next greatest element from right
     * STEP 3 : Reverse the elements after point + 1 to end to get the nextPermutation.
     */

     // TC: O(n) 
    public static int[] nextPermutation(int[] arr, int n) {
        // find the breaking point (pivot)
        int pivot = n - 2;
        while (pivot >= 0 && arr[pivot] >= arr[pivot + 1]) {
            pivot--;
        }

        // larger element to swap
        if (pivot >= 0) {
            int j = n - 1;
            while (arr[j] <= arr[pivot]) {
                j--;
            }
            swap(pivot, j, arr);
        }

        // reverse the i+1 to end
        reverse(pivot + 1, n - 1, arr);

        return arr;
    }

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int[] nums = nextPermutation(arr, n);
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }

    // for swaping
    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // for reverse
    public static void reverse(int start, int end, int[] arr) {
        while (start < end) {
            swap(start, end, arr);
            start++;
            end--;
        }
    }
}