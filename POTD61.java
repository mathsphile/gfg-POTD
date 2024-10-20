//Given a doubly linked list, each node is at most k-indices away from its target position. The problem is to sort the given doubly linked list. The distance can be assumed in either of the directions (left and right).
class Solution {
    public DLLNode sortAKSortedDLL(DLLNode head, int k) {
        if (head == null || head.next == null) {
            return head; // If list is empty or contains only one node, it's already sorted
        }

        // Create a min-heap (PriorityQueue) to help with sorting
        PriorityQueue<DLLNode> minHeap = new PriorityQueue<>(new Comparator<DLLNode>() {
            public int compare(DLLNode n1, DLLNode n2) {
                return n1.data - n2.data; // Compare based on node values
            }
        });

        DLLNode newHead = null; // To store the head of the sorted list
        DLLNode last = null; // To keep track of the last sorted node

        // Insert the first k+1 elements into the min-heap
        DLLNode current = head;
        for (int i = 0; current != null && i <= k; i++) {
            minHeap.add(current);
            current = current.next;
        }

        // Process the remaining elements in the doubly linked list
        while (!minHeap.isEmpty()) {
            // Extract the smallest node from the heap
            DLLNode smallest = minHeap.poll();

            // If this is the first node, make it the new head
            if (newHead == null) {
                newHead = smallest;
                newHead.prev = null;
                last = newHead;
            } else {
                // Append the smallest node to the sorted list
                last.next = smallest;
                smallest.prev = last;
                last = smallest;
            }

            // Add the next element from the unsorted portion of the list to the heap
            if (current != null) {
                minHeap.add(current);
                current = current.next;
            }
        }

        // Mark the end of the sorted list
        last.next = null;

        return newHead;
    }
}
