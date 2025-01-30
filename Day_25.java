import java.util.*;

/*Given a array arr of integers, return the sums of all subsets in the list. Return the sums in sorting order. */

public class Day_25 {

    public static List<Integer> subsetSums(int[] arr) {
        List<Integer> res = new ArrayList<>();
        res.add(0);

        for (int num : arr) { // O(arr.length)
            int size = res.size();
            for (int i = 0; i < size; i++) { // O(res.size) subset O(2^n)
                res.add(res.get(i) + num);
            }
        }

        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        List<Integer> res = subsetSums(arr);
        for (int sum : res) {
            System.out.print(sum + " ");
        }
    }
}