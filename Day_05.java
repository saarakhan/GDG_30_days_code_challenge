import java.util.*;

public class Day_05 {
    class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        // 3 variable 4 steps approach
        SinglyLinkedListNode curr = head, next, prev = null;
        while (curr != null) {
            next = curr.next; // storing the next
            curr.next = prev;

            // update
            prev = curr;
            curr = next;
        }
        return prev;
    }

}