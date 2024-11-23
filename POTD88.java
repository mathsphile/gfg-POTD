// public Given an array arr[] denoting heights of N towers and a positive integer K.

// For each tower, you must perform exactly one of the following operations exactly once.

// Increase the height of the tower by K
// Decrease the height of the tower by K
// Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.

// You can find a slight modification of the problem here.
// Note: It is compulsory to increase or decrease the height by K for each tower. After the operation, the resultant array should not contain any negative integers. POTD88 {
    
class Solution {
    int getMinDiff(int[] arr, int k) {
        // Sort the array
        Arrays.sort(arr);

        int n = arr.length;
        int result = arr[n - 1] - arr[0]; // Maximum difference initially

        int smallest = arr[0] + k; // Minimum possible height
        int largest = arr[n - 1] - k; // Maximum possible height

        // Swap smallest and largest if smallest becomes greater
        if (smallest > largest) {
            int temp = smallest;
            smallest = largest;
            largest = temp;
        }

        // Traverse through the sorted array and minimize the difference
        for (int i = 0; i < n - 1; i++) {
            int min = Math.min(smallest, arr[i + 1] - k);
            int max = Math.max(largest, arr[i] + k);
            if (min >= 0) { // Check for non-negative heights
                result = Math.min(result, max - min);
            }
        }

        return result;
    }
}
