import java.util.*;

public class Day_23 {
    // min changes to make substring ( of equal length of s ) anagram if each other.
    public static int minOpsToMakeAnagram(String s) {
        int len = s.length();
        if (len % 2 != 0)
            return -1; // odd length

        // substrings from string 's'
        String s1 = s.substring(0, len / 2);
        String s2 = s.substring(len / 2);

        int[] freq = new int[26];
        for (char c : s1.toCharArray())
            freq[c - 'a']++;
        for (char c : s2.toCharArray())
            freq[c - 'a']--;

        int minOps = 0;
        for (int count : freq)
            if (count > 0)
                minOps += count;

        return minOps;
    }

    // check if 2 strings are anagram
    public static boolean isAnagram(String s, String t) {
        int[] s_count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            s_count[s.charAt(i) - 'a']++;
            s_count[t.charAt(i) - 'a']--;
        }
        for (int c : s_count) {
            if (c > 0)
                return false;
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Check Anagram\n2. Make Substrings Anagram");
        int n = sc.nextInt();
        sc.nextLine();
        switch (n) {
            case 1:
                System.out.println("Enter first string (s): ");
                String s = sc.nextLine();
                System.out.println("Enter second string (t): ");
                String t = sc.nextLine();
                if (isAnagram(s, t)) {
                    System.out.println("YES, ANAGRAM");
                } else {
                    System.out.println("NOT ANAGRAM");
                }
                break;

            case 2:
                System.out.println("Enter a string to check if its substrings can be made anagrams: ");
                String str = sc.nextLine();
                int ans = minOpsToMakeAnagram(str);
                if (ans >= 0) {
                    System.out.println("Minimum changes to make substrings anagrams are: " + ans);
                } else {
                    System.out.println("No, Substrings cannot be made anagrams");
                }
                break;

            default:
                System.out.println("Invalid option. Please select 1 or 2.");
                break;
        }
        sc.close();
    }
}
