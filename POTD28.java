// Given the head of a linked list, determine whether the list contains a loop. If a loop is present, return the number of nodes in the loop, otherwise return 0.

class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        // Step 1: Detect if a loop is present using Floyd's Cycle-Finding Algorithm
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // move slow by 1 step
            fast = fast.next.next; // move fast by 2 steps

            // If slow and fast meet, there is a loop
            if (slow == fast) {
                return countLoopLength(slow);
            }
        }

        // No loop found
        return 0;
    }

    // Helper function to count the number of nodes in the loop
    private int countLoopLength(Node loopNode) {
        int count = 1;
        Node temp = loopNode;

        while (temp.next != loopNode) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}