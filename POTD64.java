// Given an array arr. Return the modified array in such a way that if the current and next numbers are valid numbers and are equal then double the current number value and replace the next number with 0. After the modification, rearrange the array such that all 0's are shifted to the end.

// Note:

// Assume ‘0’ as the invalid number and all others as a valid number.
// The sequence of the valid numbers is present in the same order.

import java.util.ArrayList;

class Solution {
    static ArrayList<Integer> modifyAndRearrangeArr(int arr[]) {
        int n = arr.length;
        
        // Step 1: Modify the array according to the given conditions
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != 0 && arr[i] == arr[i + 1]) {
                arr[i] = arr[i] * 2;  // Double the current element
                arr[i + 1] = 0;       // Set the next element to 0
            }
        }

        // Step 2: Rearrange the array by shifting all non-zero elements to the front
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                result.add(arr[i]);  // Add all non-zero elements
            }
        }
        
        // Step 3: Fill the rest of the array with 0's
        while (result.size() < n) {
            result.add(0);
        }
        
        return result;
    }
}
