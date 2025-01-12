public class Day_07 {
    // Inserting a node in doubly linked list
    /*
     * node can be inserted at 3 specific places : //! Start, mid, end
     * since sorted doubly linkedlist is given we only need to compare the curr and
     * next value
     */

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
        // Write your code here
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        // insert at begining case
        if (llist == null || llist.data > data) {
            newNode.next = llist;
            if (llist != null)
                llist.prev = newNode;
            return newNode;
        }

        DoublyLinkedListNode curr = llist;

        while (curr != null) {
            // insert at last

            if (curr.next == null && curr.data <= data) {
                curr.next = newNode;
                newNode.prev = curr;
                return llist;
            }

            // insert in some middle of DLL

            if (curr.data <= data && curr.next != null && curr.next.data > data) {
                newNode.next = curr.next;
                newNode.prev = curr;
                curr.next.prev = newNode;
                curr.next = newNode;
                return llist;
            }

            curr = curr.next;
        }
        return llist;

    }
}
