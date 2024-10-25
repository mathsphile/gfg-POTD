//Given a single linked list, calculate the sum of the last n nodes.

//POTDNote: It is guaranteed that n <= number of nodes.

class Solution {

    // Return the sum of last n nodes
    public int sumOfLastN_Nodes(Node head, int n) {
        // Initialize variables
        Node temp = head;
        int length = 0;

        // Step 1: Calculate the total length of the linked list
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // Step 2: Traverse to the (length - n)th node
        int skip = length - n;
        temp = head;
        while (skip > 0) {
            temp = temp.next;
            skip--;
        }

        // Step 3: Calculate the sum of the last n nodes
        int sum = 0;
        while (temp != null) {
            sum += temp.data;
            temp = temp.next;
        }

        return sum;
    }
}
