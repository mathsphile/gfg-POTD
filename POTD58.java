// Given an unsorted array of integers arr[], and a target tar, determine the number of subarrays whose elements sum up to the target value.

import java.util.HashMap;

class Solution {
    // Function to count the number of subarrays which adds to the given sum.
    static int subArraySum(int arr[], int tar) {
        // Create a HashMap to store cumulative sum frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int count = 0;  // To store the number of subarrays that sum to target
        int cumulativeSum = 0;  // To store the cumulative sum
        
        // Initialize the HashMap with 0 cumulative sum to handle cases where the sum of subarrays
        // from the beginning matches the target sum
        map.put(0, 1);

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            // Check if cumulativeSum - target exists in the map
            if (map.containsKey(cumulativeSum - tar)) {
                count += map.get(cumulativeSum - tar);
            }

            // Add/update the cumulativeSum in the map
            map.put(cumulativeSum, map.getOrDefault(cumulativeSum, 0) + 1);
        }

        return count;
    }
}
