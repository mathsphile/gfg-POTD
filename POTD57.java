// Given a singly linked list. The task is to find the length of the linked list, where length is defined as the number of nodes in the linked list.

class Solution {
    // Function to count nodes of a linked list.
    public int getCount(Node head) {
        // Initialize count to 0
        int count = 0;

        // Traverse the linked list
        Node current = head;
        while (current != null) {
            count++; // Increment the count for each node
            current = current.next; // Move to the next node
        }

        // Return the total count
        return count;
    }
}
