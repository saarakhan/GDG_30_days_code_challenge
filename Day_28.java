import java.util.*;

/*In Order traversal */
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

class Day_28 {
    static void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = new Node(arr[0]);
        for (int i = 1; i < n; i++) {
            insert(root, arr[i]);
        }

        inOrder(root);
        sc.close();
    }

    static void insert(Node root, int data) {
        if (data < root.data) {
            if (root.left == null) {
                root.left = new Node(data);
            } else {
                insert(root.left, data);
            }
        } else {
            if (root.right == null) {
                root.right = new Node(data);
            } else {
                insert(root.right, data);
            }
        }
    }
}
