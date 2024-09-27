// Given an array arr[] and an integer k. Find the maximum for each and every contiguous subarray of size k.

class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int k, int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        
        // Process first k elements separately
        for (int i = 0; i < k; i++) {
            // Remove all elements smaller than the current one
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }
            deque.offerLast(i); // Add new element at the rear of deque
        }
        
        // Process rest of the elements
        for (int i = k; i < arr.length; i++) {
            // The front of the deque is the largest element of the previous window
            result.add(arr[deque.peekFirst()]);
            
            // Remove the elements which are out of this window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            
            // Remove all elements smaller than the current element
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }
            
            // Add current element at the rear of the deque
            deque.offerLast(i);
        }
        
        // Add the maximum of the last window
        result.add(arr[deque.peekFirst()]);
        return result;
        
        
    }
}