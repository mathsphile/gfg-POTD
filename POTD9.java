class Solution {
    // Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        // Base cases
        if (head == null || head.next == null || k == 0)
            return head;

        // Find the length of the list
        Node current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Effective k to handle cases where k > length
        k = k % length;
        if (k == 0)
            return head; // No rotation needed

        // Traverse to the k-th node
        Node newTail = head;
        for (int i = 1; i < k; i++) {
            newTail = newTail.next;
        }

        // New head will be next of newTail
        Node newHead = newTail.next;

        // Break the link
        newTail.next = null;

        // Connect the last node to the old head
        current.next = head;

        return newHead;

    }
}
