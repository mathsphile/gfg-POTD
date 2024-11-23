class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {
        // Initialize maxSum to the smallest integer value
        int maxSum = Integer.MIN_VALUE;

        // Initialize currentSum to 0
        int currentSum = 0;

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Add the current element to the currentSum
            currentSum += arr[i];

            // Update maxSum if currentSum is greater
            maxSum = Math.max(maxSum, currentSum);

            // If currentSum becomes negative, reset it to 0
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        // Return the maximum sum found
        return maxSum;
    }
}
