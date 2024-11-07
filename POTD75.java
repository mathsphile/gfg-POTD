//Given an array, arr[], determine if arr can be split into three consecutive parts such that the sum of each part is equal. If possible, return any index pair(i, j) in an array such that sum(arr[0..i]) = sum(arr[i+1..j]) = sum(arr[j+1..n-1]), otherwise return an array {-1,-1}.

//Note: Driver code will print true if arr can be split into three equal sum subarrays, otherwise, it is false.

// User function Template for Java
import java.util.ArrayList;
import java.util.List;

class Solution {
    // Function to determine if array arr can be split into three equal sum sets.
    public List<Integer> findSplit(int[] arr) {
        List<Integer> result = new ArrayList<>();

        // Step 1: Calculate the total sum of the array
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // Step 2: Check if the total sum is divisible by 3
        if (totalSum % 3 != 0) {
            result.add(-1);
            result.add(-1);
            return result; // Cannot split if total sum is not divisible by 3
        }

        int targetSum = totalSum / 3;
        int currentSum = 0;
        int count = 0;
        int i = -1, j = -1;

        // Step 3: Find two indices to split the array into three parts with equal sums
        for (int k = 0; k < arr.length; k++) {
            currentSum += arr[k];

            if (currentSum == targetSum) {
                count++;
                currentSum = 0;

                // Mark the indices i and j for the split
                if (count == 1) {
                    i = k;
                } else if (count == 2) {
                    j = k;
                    break;
                }
            }
        }

        // If we found two splits that divide the array into three equal parts
        if (count == 2 && j < arr.length - 1) {
            result.add(i);
            result.add(j);
        } else {
            result.add(-1);
            result.add(-1);
        }

        return result;
    }
}
