// Given an array of integers arr[] representing a permutation, implement the next permutation that rearranges the numbers into the lexicographically next greater permutation. If no such permutation exists, rearrange the numbers into the lowest possible order (i.e., sorted in ascending order). 

// Note - A permutation of an array of integers refers to a specific arrangement of its elements in a sequence or linear order. POTD84 {
    
class Solution {
    void nextPermutation(int[] arr) {
        int n = arr.length;
        int i = n - 2;

        // Step 1: Find the first decreasing element from the right
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // Step 2: Find the next larger element on the right of the found element
            int j = n - 1;
            while (j >= 0 && arr[j] <= arr[i]) {
                j--;
            }
            // Step 3: Swap the two elements
            swap(arr, i, j);
        }

        // Step 4: Reverse the elements to the right of the original index i
        reverse(arr, i + 1, n - 1);
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
