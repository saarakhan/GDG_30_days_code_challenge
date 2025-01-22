import java.util.*;

public class Day_17 {
    // for 1 arr
    public static void nextGreaterElementI(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        System.out.println("nextGreaterElement I");

        for (int res : result) {
            System.out.print(res + " ");
        }
    }

    // Leetcode 496. 2 arr
    public static void nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Stack<Integer> stk = new Stack<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int n : nums2) {
            while (!stk.isEmpty() && stk.peek() < n) {
                hm.put(stk.pop(), n);
            }
            stk.push(n);
        }

        while (!stk.isEmpty()) {
            hm.put(stk.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = hm.get(nums1[i]);
        }
        System.out.println("nextGreaterElement II");
        for (int n : res) {
            System.out.print(n + " ");
        }

    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Give n");
        int n = sc.nextInt();
        System.out.println("Give total Array value" + n);
        int[] nums1 = new int[n];

        for (int i = 0; i < n; i++)
            nums1[i] = sc.nextInt();

        System.out.println("Give m");
        int m = sc.nextInt();
        System.out.println("Give total Array value" + m);
        int[] nums2 = new int[m];
        for (int i = 0; i < m; i++)
            nums2[i] = sc.nextInt();
        nextGreaterElement(nums1, nums2);

        nextGreaterElementI(nums1);
        sc.close();
    }
}