// There is an array arr of heights of stone and Geek is standing at the first stone and can jump to one of the following: Stone i+1, i+2, ... i+k stone, where k is the maximum number of steps that can be jumped and cost will be |hi-hj| is incurred, where j is the stone to land on. Find the minimum possible total cost incurred before the Geek reaches the last stone.

class Solution {
    public int minimizeCost(int k, int arr[]) {
        int n = arr.length;
        // dp[i] will store the minimum cost to reach stone i
        int[] dp = new int[n];

        // Initialize the dp array with a large number, except for the first stone
        dp[0] = 0; // No cost to stay on the first stone

        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE; // Start with max value for each stone
            // Check for all stones that can be reached from i-1 to i-k
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(arr[i] - arr[i - j]));
                }
            }
        }

        // The minimum cost to reach the last stone is stored in dp[n-1]
        return dp[n - 1];
    }
}
