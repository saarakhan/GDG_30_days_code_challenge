public class Day_13 {
    /*
     * KOKO eating Banana
     * question : minimum speed(k) under which koko finishes eating all piles banana
     * within h hours.
     * 
     * 
     * need to decide a speed from 1 to max number at which k <= h
     * if at k = low (1) eating speed is much then neglect the low part
     * if at k = high (max) eating speed is less then possible high - 1 can give
     * less speed hence neglect right part
     * can apply binary search on low to high
     

     * lets take an example : piles = [3, 6, 7, 11]
     *       k = 1 (speed)
     *       total_hours = 3/1 + 6/1 + 7/1 + 11/1 = 27 hrs > 8 hrs (Can't take speed 1)
     *       k = 2
     *       total_hours = 3/2 + 6/2 + 7/2 + 11/2 = 15hrs > 8 hrs (Can't take speed 2)
     * 
     *       k = 3
     *       total_hours = 3/3 + 6/3 + 7/3 + 11/3 = 10 hrs >= 8 hrs (Can't take speed 3)
     *      
     *        //! minimum value of k such that >= hours
     *       k = 4
     *       total_hours = 3/4 + 6/4 + 7/4 + 11/4 = 8 hrs >= 8 hrs ( Yes can take k)
     * 
     */

     // linear - 1, 2, 3, 4---- can take O(n)
     // rather les go with binary taking mid then removing left or right - O(nlogn)

    
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = getMax(piles, piles.length);
        while (low <= high) {
            int mid = (low + high) / 2;
            int totHrs = getHour(piles, mid);
            if (totHrs <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    //! max number in the array
    public int getMax(int[] arr, int n) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        return maxi;
    }

    //! the total hours taken by koko at speed k to eat all bananas
    public int getHour(int[] piles, int k) {
        int totHrs = 0;
        int n = piles.length;
        for (int i = 0; i < n; i++) {
            totHrs += Math.ceil((double) piles[i] / (double) k);
        }
        return totHrs;
    }
}