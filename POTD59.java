// Given a singly linked list'shead.Your task is to complete the function alternatingSplitList()that splits the given linked list into two smaller lists.The sublists should be made from alternating elements from the original list.Note:

// The sublist should be in the order with respect to the original list.Your have to return an array containing the both sub-linked lists.

class Solution {
    // Function to append a new node with newData at the end of a linked list
    Node[] alternatingSplitList(Node head) {
  
        // Initialize two dummy nodes for two sublists
        Node head1 = null, tail1 = null;
        Node head2 = null, tail2 = null;
        
        // To keep track of alternating nodes
        boolean toggle = true;
        
        // Traverse the original list
        Node current = head;
        while (current != null) {
            if (toggle) {
                // Add to first list
                if (head1 == null) {
                    head1 = current;
                    tail1 = head1;
                } else {
                    tail1.next = current;
                    tail1 = tail1.next;
                }
            } else {
                // Add to second list
                if (head2 == null) {
                    head2 = current;
                    tail2 = head2;
                } else {
                    tail2.next = current;
                    tail2 = tail2.next;
                }
            }
            // Toggle between the two lists
            toggle = !toggle;
            // Move to the next node
            current = current.next;
        }
        
        // Ensure both lists terminate correctly
        if (tail1 != null) tail1.next = null;
        if (tail2 != null) tail2.next = null;
        
        // Return the two heads as an array
        return new Node[] {head1, head2};
    }
}
