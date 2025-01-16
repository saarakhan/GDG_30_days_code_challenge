
/*
 * There is an integer array nums sorted in ascending order (with distinct
 * values).
 * 
 * Prior to being passed to your function, nums is possibly rotated at an
 * unknown pivot index k (1 <= k < nums.length) such that the resulting array is
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3
 * and become [4,5,6,7,0,1,2].
 * 
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 */
//! linear time - 0(n) and binary search - O(nlogn)
public class Day_11 {
    /*
     * Search in sorted rotated array
     */
    public static int rotatedSorted(int[] nums, int n, int tar) {
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == tar)
                return mid;

            // left part sorted
            if (nums[left] <= nums[mid]) {
                // tar in left
                if (nums[left] <= tar && tar < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // right part sorted, tar in right
                if (nums[mid] < tar && tar <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
