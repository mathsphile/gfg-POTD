// Given an array of integers arr, the task is to find and return the maximum sum of the smallest and second smallest element among all possible subarrays of size greater than one. If it is not possible, then return -1.

class Solution {
    public int pairWithMaxSum(int[] arr) {
        // If the array has less than 2 elements, return -1 since no valid subarray exists
        if (arr.length < 2) {
            return -1;
        }
        
        // Initialize maxSum to the minimum possible value
        int maxSum = Integer.MIN_VALUE;
        
        // Traverse the array and calculate the sum of each consecutive pair
        for (int i = 1; i < arr.length; i++) {
            // Calculate sum of consecutive elements
            int currentSum = arr[i] + arr[i - 1];
            
            // Update maxSum if currentSum is greater
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        
        return maxSum;


    }
}
