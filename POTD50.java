// Given an array arr integers. Assume sz to be the initial size of the array. Do the following operations exactly sz/2 times. In every kth (1<= k <= sz/2) operation:

// Right-rotate the array clockwise by 1.
// Delete the (n– k + 1)th element from begin.
// Now, Return the first element of the array.
// Note: Here n keeps on decreasing with every operation.


class Solution {
    public static int rotateDelete(ArrayList<Integer> arr) {
        int sz = arr.size();  // Initial size of the array

        // Perform the operations exactly sz/2 times
        for (int k = 1; k <= sz / 2; k++) {
            // Right-rotate the array by 1
            Collections.rotate(arr, 1);

            // Remove the (n - k + 1)th element from the beginning
            int n = arr.size();  // Current size of the array
            arr.remove(n - k);
        }

        // Return the first element of the modified array
        return arr.get(0);
    }
}

