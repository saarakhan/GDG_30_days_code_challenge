import java.io.*;
import java.util.*;
public class Day_01 {
    
    static int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        // HashMap - To store index and value 
         HashMap<Integer, Integer> hm = new HashMap<>(); 
        
        for(int i=0; i<n; i++) {
            // check if target - current value exists
            int diff = target - arr[i];
            if(hm.containsKey(diff)) {
                return new int[]{hm.get(diff),i};
            }
            hm.put(arr[i], i); // if diff not exists then put the pair in Hashmap
        }
        return new int[0];
    }

    public static void main(String[] args)  throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        int[] nums = Arrays.stream(sc.nextLine().split(" "))
                           .mapToInt(Integer::parseInt)
                           .toArray();

        int target = sc.nextInt();
        
        int[] res = twoSum(nums, target);
        if (res.length == 2) {
            System.out.println("{" + res[0] + ", " + res[1] + "}");
        } else {
            System.out.println("{}");
        }
    }
}
