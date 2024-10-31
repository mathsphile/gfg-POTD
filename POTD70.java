
class Solution {
    public Node sortedInsert(Node head, int x) {
         Node newNode = new Node(x);

        // Case 1: If the list is empty, the new node becomes the head
        if (head == null) {
            return newNode;
        }

        // Case 2: If the new node should be inserted at the beginning
        if (x < head.data) {
            newNode.next = head;
            head.prev = newNode;
            return newNode; // new node is the new head
        }

        // Traverse the list to find the correct insertion point
        Node current = head;
        while (current.next != null && current.next.data < x) {
            current = current.next;
        }

        // Insert the new node after the current node
        newNode.next = current.next;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
        newNode.prev = current;

        return head;
    }
}