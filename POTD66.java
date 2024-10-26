// Given a singly linked list and a key, count the number of occurrences of the given key in the linked list.

public class Solution {
    public static int count(Node head, int key) {
        int count = 0;
        Node current = head;
        
        // Traverse the list
        while (current != null) {
            // If the current node's data matches the key, increment the count
            if (current.data == key) {
                count++;
            }
            // Move to the next node
            current = current.next;
        }
        
        return count;
    }
}
 POTD66 {
    
}
