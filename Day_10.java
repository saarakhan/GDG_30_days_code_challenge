import java.util.*;
public class Day_10 {
    /* Floor in a sorted array */
    /*
     * sorted array is given
     * find the element which is largest less than equal to k(target)
     * intiuation : //! sorted -> can be applied Binary Search 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int ans = -1;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= k) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}