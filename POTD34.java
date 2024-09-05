// Given an array arr of size n−1 that contains distinct integers in the range of 1 to n (inclusive), find the missing element. The array is a permutation of size n with one element missing. Return the missing element.

class Solution {

    // Note that the size of the array is n-1
    int missingNumber(int n, int arr[]) {

        // Calculate the expected sum of numbers from 1 to n
        int totalSum = n * (n + 1) / 2;

        // Calculate the sum of elements in the array
        int arraySum = 0;
        for (int i = 0; i < n - 1; i++) {
            arraySum += arr[i];
        }

        // The missing number is the difference between the expected sum and the array
        // sum
        return totalSum - arraySum;
    }
}