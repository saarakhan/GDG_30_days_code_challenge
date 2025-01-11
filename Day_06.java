// cycle detection in a linkedlist
public class Day_06 {
    class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    // ! A famous algo floyd detection or hair-tortoise is used for this
    // ! in this 2 pointers are maintained slow & fast
    /*
     * slow pointer moves one step ahead (slow.next)
     * fast pointer moves 2 steps ahead (fast.next.next)
     * if any point this two meet, that means cycle exist
     */
    static boolean hasCycle(SinglyLinkedListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // 1 step
            fast = fast.next.next; // 2step
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}