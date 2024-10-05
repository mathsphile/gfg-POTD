// Given a sorted array arr[] of positive integers, find the smallest positive integer such that it cannot be represented as the sum of elements of any subset of the given array set.

class Solution {
    public long findSmallest(int[] arr) {
        long res = 1; // Initialize the result as 1 (smallest positive integer)
        
        // Traverse the array and update res if arr[i] is smaller than or equal to res
        for (int i = 0; i < arr.length && arr[i] <= res; i++) {
            res += arr[i];
        }
        
        return res; // This is the smallest positive integer that cannot be represented
    }
}
