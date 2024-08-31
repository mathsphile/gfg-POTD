// Given two sorted arrays of distinct integers arr1 and arr2. Each array may have some elements in common with the other array. Find the maximum sum of a path from the beginning of any array to the end of any array. You can switch from one array to another array only at the common elements.

// Note:  When we switch from one array to other,  we need to consider the common element only once in the result.

class Solution {
    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        int n = arr1.size();
        int m = arr2.size();
        int i = 0, j = 0;
        int sum1 = 0, sum2 = 0;
        int result = 0;

        while (i < n && j < m) {
            // If the current element of arr1 is smaller, add it to sum1
            if (arr1.get(i) < arr2.get(j)) {
                sum1 += arr1.get(i++);
            }
            // If the current element of arr2 is smaller, add it to sum2
            else if (arr1.get(i) > arr2.get(j)) {
                sum2 += arr2.get(j++);
            }
            // If both elements are the same, choose the maximum path and move forward
            else {
                result += Math.max(sum1, sum2) + arr1.get(i);
                i++;
                j++;
                sum1 = 0;
                sum2 = 0;
            }
        }

        // Add remaining elements of arr1
        while (i < n) {
            sum1 += arr1.get(i++);
        }

        // Add remaining elements of arr2
        while (j < m) {
            sum2 += arr2.get(j++);
        }

        // Add the maximum of the remaining paths
        result += Math.max(sum1, sum2);

        return result;
    }
}