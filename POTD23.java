// You are given weights and values of items, and put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
// In other words, given two integer arrays val and wt which represent values and weights associated with items respectively. Also given an integer W which represents knapsack capacity, find out the maximum sum values subset of val[] such that the sum of the weights of the corresponding subset is smaller than or equal to W. You cannot break an item, either pick the complete item or don't pick it (0-1 property).


class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
       int n = wt.length; // Number of items

        // DP table where dp[i][j] represents the maximum value that can be achieved 
        // with the first i items and a knapsack capacity of j
        int dp[][] = new int[n + 1][W + 1];

        // Build the table dp[][] in bottom up manner
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0; // Base case: no items or zero capacity means zero value
                } else if (wt[i - 1] <= j) {
                    // Maximum value of two cases:
                    // 1. Not including the current item
                    // 2. Including the current item
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j]; // Cannot include the current item
                }
            }
        }

        // The maximum value that can be achieved with the given capacity
        return dp[n][W];
    }
}
