import java.util.*;

public class Day_19 {
    /*
     * You are given an array of integers nums, there is a sliding window of size k
     * which is moving from the very left of the array to the very right. You can
     * only see the k numbers in the window. Each time the sliding window moves
     * right by one position.
     * 
     * Return the max sliding window.
     */

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (nums == null || n == 0)
            return new int[0];

        int[] result = new int[n - k + 1];
        Deque<Integer> d = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // out of window element remove that element index from deque
            if (!d.isEmpty() && d.peek() < i - k + 1) {
                d.poll();
            }

            // smaller element - remove that element index from deque
            while (!d.isEmpty() && nums[d.peekLast()] < nums[i]) {
                d.pollLast();
            }

            // add current index
            d.offer(i);

            // deque will always has the max value at front
            if (i >= k - 1) {
                result[i - k + 1] = nums[d.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        int k = sc.nextInt();
        int[] result = maxSlidingWindow(nums, k);

        System.out.println(Arrays.toString(result));
        sc.close();
    }
}

/*
 * Traverse the array from left to right.
 * Maintain a deque where:
 * The front of the deque contains the index of the maximum element for the
 * current window.
 * Indices that are out of the current window are removed.
 * Indices of elements that are smaller than the current element are removed
 * from the back, as they are no longer useful.
 * After processing each index, the front of the deque gives the maximum for the
 * current window.
 * Continue sliding the window until the end of the array.
 */