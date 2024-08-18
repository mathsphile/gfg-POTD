// public Given an array of integers arr, return true if it is possible to split it in two subarrays (without reordering the elements), such that the sum of the two subarrays are equal. If it is not possible then return false. 
class Solution {
    public boolean canSplit(int arr[]) {
        int totalSum = 0;

        // Calculate the total sum of the array
        for (int num : arr) {
            totalSum += num;
        }

        // If the total sum is odd, it's impossible to split into two equal subarrays
        if (totalSum % 2 != 0) {
            return false;
        }

        int leftSum = 0;
        int target = totalSum / 2;

        // Iterate through the array to find the split point
        for (int num : arr) {
            leftSum += num;

            // If the left sum equals half of the total sum, return true
            if (leftSum == target) {
                return true;
            }
        }

        // If no split point was found, return false
        return false;
    }
}
