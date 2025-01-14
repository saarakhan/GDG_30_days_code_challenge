import java.util.*;

/*
    * Given an array of intervals intervals where intervals[i] = [startᵢ, endᵢ], 
    * return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
    * Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.
 */

public class Day_09 {
    /*
     * Intiuation was to check if end is greater than equal to prev start.
     * we sorted the pair based on end to ensure the greedy approach to minimize
     * overlaps
     */

    // ! similar questions :
    /*
     * 56. Merge Intervals
     * Meeting Rooms II (premium)
     */

    public static void sort(int[][] arr) {
        Arrays.sort(arr,
                (a, b) -> Integer.compare(a[1], b[1]));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        // sorting the intervals with the end part
        sort(intervals);

        int count = 0;
        int le = Integer.MIN_VALUE;

        // checking if start > the last end , if not then inc. count else updating the
        // last end with current end
        for (int[] interval : intervals) {
            if (interval[0] < le)
                count++;
            else {
                le = interval[1];
            }
        }

        System.out.println(count);
        sc.close();
    }
}
