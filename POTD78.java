// Given an array arr[ ], your task is to find the minimum number of increment operations required to make all the elements of the array unique. i.e.- no value in the array should occur more than once. In one operation, a value can be incremented by 1 only.

import java.util.Arrays;

class Solution {
    public int minIncrements(int[] arr) {
        // Step 1: Sort the array
        Arrays.sort(arr);
        
        int operations = 0;
        
        // Step 2: Iterate through the array and increment duplicates
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                int increment = arr[i - 1] + 1 - arr[i];
                arr[i] += increment;
                operations += increment;
            }
        }
        
        return operations;
    }
}
