// You are given an integer array arr[]. Your task is to find the smallest positive number missing from the array.

// Note: Positive number starts from 1. The array can have negative integers too.

class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        int n = arr.length;

        // Step 1: Place each positive number at its correct index
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                // Swap arr[i] and arr[arr[i] - 1]
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }

        // Step 2: Find the first index where the number does not match
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1; // The smallest positive missing number
            }
        }

        // Step 3: If all numbers from 1 to n are present, return n + 1
        return n + 1;
    }
}
