// Given a Singly Linked List, Delete all alternate nodes of the list ie delete all the nodes present in even positions.

class Solution {
    public void deleteAlt(Node head) {
        if (head == null) return; // If the list is empty, do nothing

        Node current = head; // Start from the head of the list

        while (current != null && current.next != null) {
            // Skip the next node (i.e., delete the node at even position)
            current.next = current.next.next;
            
            // Move to the next node (which is now an odd-positioned node)
            current = current.next;
        }
    }
}