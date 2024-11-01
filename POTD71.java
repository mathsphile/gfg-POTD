import java.util.Arrays;

class Solution {
    public long maxSum(Long[] arr) {
        // Sort the array to arrange elements alternately
        Arrays.sort(arr);

        int n = arr.length;
        Long[] temp = new Long[n];

        // Arrange elements in max-min order
        int left = 0, right = n - 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                temp[i] = arr[left++];
            } else {
                temp[i] = arr[right--];
            }
        }

        // Calculate maximum sum of absolute differences
        long maxSum = 0;
        for (int i = 0; i < n - 1; i++) {
            maxSum += Math.abs(temp[i] - temp[i + 1]);
        }
        // Add the difference between last and first element for circular sum
        maxSum += Math.abs(temp[n - 1] - temp[0]);

        return maxSum;
    }
}
