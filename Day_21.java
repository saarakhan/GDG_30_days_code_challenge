import java.util.*;
// Remove k digits  402. Leetcode
public class Day_21 {
    public static String removeKdigits(String num, int k) {
        // Create a StringBuilder to use as a stack to keep track of digits.
        StringBuilder stack = new StringBuilder();

        for (char digit : num.toCharArray()) {
            // While the current digit is smaller than the last digit in the stack
            // and we still have digits to remove (k > 0), remove the last digit.
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > digit) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            // Append the current digit to the stack (StringBuilder).
            stack.append(digit);
        }

        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // Remove leading zeros by finding the index of the first non-zero digit.
        int nonZeroIndex = 0;
        while (nonZeroIndex < stack.length() && stack.charAt(nonZeroIndex) == '0') {
            nonZeroIndex++;
        }
        String result = stack.substring(nonZeroIndex);

        return result.isEmpty() ? "0" : result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter String num :");
        String num = sc.nextLine();
        // System.out.println("Enter 'k' the digits to be removed : ");
        int k = sc.nextInt();
        System.out.println(removeKdigits(num, k));
    }
}

