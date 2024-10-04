//Given a Circular Linked List. The task is to delete the given node, key in the circular linked list, and reverse the circular linked list.

// Note: You don't have to print anything, just return head of the modified list in each function

class Solution {
    // Function to reverse a circular linked list
    Node reverse(Node head) {
        // If list is empty or has only one node
        if (head == null || head.next == head) {
            return head;
        }
        
        // Use three pointers to reverse the links
        Node prev = null;
        Node current = head;
        Node next;
        
        // First node will become last node after reversal
        Node lastNode = head;
        
        // Traverse and reverse links until we reach first node again
        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != head);
        
        // Connect last node to first node to maintain circular nature
        head = prev;
        lastNode.next = head;
        
        return head;
    }
    
    // Function to delete a node with given key
    Node deleteNode(Node head, int key) {
        // If list is empty
        if (head == null) {
            return null;
        }
        
        // If list has only one node
        if (head.next == head) {
            if (head.data == key) {
                return null;
            }
            return head;
        }
        
        Node current = head;
        Node prev = null;
        
        // Find the node to be deleted
        while (current.data != key) {
            // If key not found
            if (current.next == head) {
                return head;
            }
            prev = current;
            current = current.next;
        }
        
        // If node to be deleted is head
        if (current == head) {
            // Find the last node
            prev = head;
            while (prev.next != head) {
                prev = prev.next;
            }
            head = current.next;
            prev.next = head;
        }
        // If node to be deleted is not head
        else {
            prev.next = current.next;
        }
        
        return head;
    }
}