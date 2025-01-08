import java.io.*;
import java.util.*;

public class Day_03 {

    // Find the value which is minimum and calculate profit by subtracting the
    // current arr value
    // if current profit is greater than maxProfit , update maxProfit

    // ! so buying the minumum value for stock and selling(storing in maxProfit)
    // ! when profit is larger then previous

    // O(n)
    public static int buySellStock(int[] arr) {

        int maxProfit = 0, price = Integer.MAX_VALUE;

        for (int a : arr) {
            // minimum value of price to buy
            if (a < price) {
                price = a;
            }

            // calculating profit for selling
            int profit = a - price;

            // if profit at current is more then update maxProfit
            if (profit > maxProfit) {
                maxProfit = profit;
            }

        }
        return maxProfit;
    }

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(buySellStock(arr));
    }
}