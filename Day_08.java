/*
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

    You must solve this problem without using the library's sort function.

    Input Format

    First line of input consists of a single digit n denoting the size of array, a.
    The second line contains n space-separated integers, where each integer is either 0, 1, or 2.
*/
public class Day_08 {
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

        // sort array
        Arrays.sort(arr);
        for (int a : arr)
            System.out.print(a + " ");
    }

}
