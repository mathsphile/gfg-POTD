class Solution {
        // Function to find the maximum number of cuts.
        public int maximizeCuts(int n, int x, int y, int z) {
            // Array to store the maximum cuts possible for each length.
            int[] dp = new int[n + 1];

            // Initializing dp[0] to 0 since no cuts are needed for a length of 0.
            dp[0] = 0;

            // Iterating over all lengths from 1 to n.
            for (int i = 1; i <= n; i++) {
                // Check if it's possible to make a cut of length x.
                if (i >= x && dp[i - x] != -1) {
                    dp[i] = Math.max(dp[i], dp[i - x] + 1);
                }
                // Check if it's possible to make a cut of length y.
                if (i >= y && dp[i - y] != -1) {
                    dp[i] = Math.max(dp[i], dp[i - y] + 1);
                }
                // Check if it's possible to make a cut of length z.
                if (i >= z && dp[i - z] != -1) {
                    dp[i] = Math.max(dp[i], dp[i - z] + 1);
                }

                // If no cuts are possible, mark dp[i] as -1.
                if (dp[i] == 0) {
                    dp[i] = -1;
                }
            }

            // If dp[n] is -1, it means no cuts were possible, so return 0.
            return dp[n] == -1 ? 0 : dp[n];
        }
    }


    

