// Given two sorted arrays a[] and b[], where each array contains distinct elements , the task is to return the elements in the union of the two arrays in sorted order.

// Union of two arrays can be defined as the set containing distinct common elements that are present in either of the arrays.
import java.util.ArrayList;

class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0, j = 0;

        // Traverse through both arrays
        while (i < a.length && j < b.length) {
            // Skip duplicate elements in the same array
            while (i > 0 && i < a.length && a[i] == a[i - 1])
                i++;
            while (j > 0 && j < b.length && b[j] == b[j - 1])
                j++;

            // Check if we are within bounds after removing duplicates
            if (i < a.length && j < b.length) {
                if (a[i] < b[j]) {
                    union.add(a[i]);
                    i++;
                } else if (a[i] > b[j]) {
                    union.add(b[j]);
                    j++;
                } else {
                    // When a[i] == b[j]
                    union.add(a[i]);
                    i++;
                    j++;
                }
            }
        }

        // Add remaining elements from array `a`
        while (i < a.length) {
            if (i == 0 || a[i] != a[i - 1]) {
                union.add(a[i]);
            }
            i++;
        }

        // Add remaining elements from array `b`
        while (j < b.length) {
            if (j == 0 || b[j] != b[j - 1]) {
                union.add(b[j]);
            }
            j++;
        }

        return union;
    }
}
