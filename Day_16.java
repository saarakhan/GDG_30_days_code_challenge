import java.util.*;

public class Day_16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackUsingQueues stack = new StackUsingQueues();
        
        int n = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.startsWith("push")) {
                int x = Integer.parseInt(line.split(" ")[1]);
                stack.push(x);
            } else if (line.equals("pop")) {
                stack.pop();
            } else if (line.equals("top")) {
                int top = stack.top();
                if (top == -1) {
                    System.out.println("Stack is empty!");
                } else {
                    System.out.println(top);
                }
            } else if (line.equals("empty")) {
                System.out.println(stack.empty() ? 1 : 0);
            }
        }
        scanner.close();
    }
}

class StackUsingQueues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    
    public StackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public void pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty!"); 
            return;
        }
        q1.poll();
    }
    
    public int top() {
        if (q1.isEmpty()) {
            return -1; 
        }
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}
