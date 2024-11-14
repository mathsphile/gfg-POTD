//Given an array arr[], where each element is at most k away from its target position, you need to sort the array optimally.

// Note: DO NOT use direct library sort() function for this question.import java.util.PriorityQueue;

class Solution {
    // Non-static method to sort the nearly sorted array
    public void nearlySorted(int[] arr, int k) {
        // Create a min-heap (priority queue)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        int index = 0;
        // Traverse through the array
        for (int i = 0; i < arr.length; i++) {
            // Add the current element to the heap
            minHeap.add(arr[i]);
            
            // If the heap size exceeds k, remove the minimum element and place it in the sorted position
            if (minHeap.size() > k) {
                arr[index++] = minHeap.poll();
            }
        }
        
        // Place remaining elements from the heap into the array
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }
}
