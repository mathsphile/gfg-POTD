// Given two strings str1 and str2. Return the minimum number of operations required to convert str1 to str2.
// The possible operations are permitted:

// 1.Insert a character at any position of the string.
// 2.Remove any character from the string.
// 3.Replace any character from the string with any other character.


class Solution {
    public int editDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // Create a 2D array to store the distances
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // If str2 is empty, we need i operations to delete all characters from str1
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // If str1 is empty, we need j operations to insert all characters to str2
        }

        // Fill the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // No operation needed if characters are the same
                } else {
                    dp[i][j] = 1 + Math.min(
                            Math.min(dp[i - 1][j], // Remove
                                    dp[i][j - 1]), // Insert
                            dp[i - 1][j - 1] // Replace
                    );
                }
            }
        }

        return dp[m][n];
    }
}
