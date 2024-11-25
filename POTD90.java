// Given an array arr[] that contains positive and negative integers (may contain 0 as well). Find the maximum product that we can get in a subarray of arr.

// Note: It is guaranteed that the output fits in a 32-bit integer.

class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        // Base case: if array length is 0, return 0
        if (arr.length == 0)
            return 0;

        // Initialize variables
        int maxProduct = arr[0]; // To store the maximum product found so far
        int currentMax = arr[0]; // To store the maximum product ending at the current position
        int currentMin = arr[0]; // To store the minimum product ending at the current position (needed because a
                                 // negative number multiplied by a negative product can become positive)

        // Traverse the array
        for (int i = 1; i < arr.length; i++) {
            int temp = currentMax; // Store the current max to use in updating currentMin

            // Update currentMax by considering the current element,
            // the product of the current element and the previous max,
            // and the product of the current element and the previous min
            currentMax = Math.max(arr[i], Math.max(arr[i] * currentMax, arr[i] * currentMin));

            // Update currentMin similarly
            currentMin = Math.min(arr[i], Math.min(arr[i] * temp, arr[i] * currentMin));

            // Update the maximum product found so far
            maxProduct = Math.max(maxProduct, currentMax);
        }

        // Return the maximum product found
        return maxProduct;
    }
}
