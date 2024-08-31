// You are given an array arr, you need to find any three elements in it such that arr[i] < arr[j] < arr[k] and i < j < k.

// Note:

// The output will be 1 if the subsequence returned by the function is present in the array arr
// If the subsequence is not present in the array then return an empty array, the driver code will print 0.
// If the subsequence returned by the function is not in the format as mentioned then the output will be -1.

class Solution {
    // Function to find three numbers such that arr[smaller[i]] < arr[i] <
    // arr[greater[i]]
    public List<Integer> find3Numbers(int[] arr) {
        int n = arr.length;
        if (n < 3)
            return new ArrayList<>(); // Edge case, no triplet is possible

        // Arrays to store indexes of smaller and greater elements
        int[] smaller = new int[n];
        int[] greater = new int[n];

        // Initialize the arrays
        smaller[0] = -1;
        greater[n - 1] = -1;

        // Fill the smaller array
        int min = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[min]) {
                min = i;
                smaller[i] = -1;
            } else {
                smaller[i] = min;
            }
        }

        // Fill the greater array
        int max = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[max]) {
                max = i;
                greater[i] = -1;
            } else {
                greater[i] = max;
            }
        }

        // Now find a triplet such that smaller[i] != -1 and greater[i] != -1
        for (int i = 1; i < n - 1; i++) {
            if (smaller[i] != -1 && greater[i] != -1) {
                List<Integer> result = new ArrayList<>();
                result.add(arr[smaller[i]]);
                result.add(arr[i]);
                result.add(arr[greater[i]]);
                return result;
            }
        }

        // No such triplet found
        return new ArrayList<>();
    }
}