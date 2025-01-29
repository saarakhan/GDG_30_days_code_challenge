import java.util.*;

public class Day_24 {

    /*
     * Write a function to find the longest common prefix string amongst an array of
     * strings.
     * If there is no common prefix, return an empty string "".
     */
    // ! BRUTE FORCE O(min(s1.length(), s2.length()))
    public static String longestPrefix_BruteForce(String s1, String s2) {
        int minLen = Math.min(s1.length(), s2.length());
        int i = 0;

        while (i < minLen && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return s1.substring(0, i);
    }

    // ! OPTIMISE O(logn)
    public static String longestPrefix_Optimise(String s1, String s2) {
        int minLen = Math.min(s1.length(), s2.length());
        int low = 0, high = minLen;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (s1.substring(0, mid).equals(s2.substring(0, mid))) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return s1.substring(0, (low + high) / 2);
    }

    public static void main(String args[]) {
        // String[] arr = { "racecar", "racecard", "racecaring" };
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLine();

        String longest = arr[0];
        for (int i = 1; i < arr.length; i++) { // O(n)
            longest = longestPrefix_Optimise(longest, arr[i]);
            if (longest.isEmpty())
                break;
        }
        System.out.println(longest.isEmpty() ? "" : longest);
        sc.close();
    }
}

/*
 * TC: O(logN) + O(n)
 * SC:O(1)
 */