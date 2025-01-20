import java.util.*;

//! refer "image > Prefix-infix"
public class Day_15 {

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static String convertToInfix(String prefix) {
        int n = prefix.length();
        Stack<String> stk = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);
            if (isOperator(ch)) {
                String operand1 = stk.pop();
                String operand2 = stk.pop();
                String expression = "(" + operand1 + " " + ch + " " + operand2 + ")";
                stk.push(expression);
            } else {
                stk.push(Character.toString(ch));
            }
        }
        return stk.pop();
    }

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Scanner sc = new Scanner(System.in);
        String prefix = sc.nextLine();
        String infix = convertToInfix(prefix);
        System.out.println(infix);
        sc.close();
    }
}
