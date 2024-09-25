//Given a singly linked list of integers. The task is to check if the given linked list is palindrome or not.

class Solution {
    // Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find the middle of the linked list
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list
        slow = reverseList(slow);

        // Step 3: Compare the first half and the second half
        Node firstHalf = head;
        Node secondHalf = slow;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // Helper function to reverse the linked list
    Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
