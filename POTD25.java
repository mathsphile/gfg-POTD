// Given two strings pattern and str which may be of different size, You have to return 1 if the wildcard pattern i.e. pattern, matches with str else return 0. All characters of the string str and pattern always belong to the Alphanumeric characters.

// The wildcard pattern can include the characters ? and *
// ‘?’ – matches any single character.
// ‘*’ – Matches any sequence of characters (including the empty sequence).

// Note: The matching should cover the entire str (not partial str).

class Solution {
    public int wildCard(String pattern, String str) {
        int pLen = pattern.length();
        int sLen = str.length();

        // Create a DP table to store the results
        boolean[][] dp = new boolean[pLen + 1][sLen + 1];

        // Base case: Empty pattern and empty string match
        dp[0][0] = true;

        // Handle cases where pattern starts with *
        for (int i = 1; i <= pLen; i++) {
            if (pattern.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0];
            }
        }

        // Fill the DP table
        for (int i = 1; i <= pLen; i++) {
            for (int j = 1; j <= sLen; j++) {
                char pChar = pattern.charAt(i - 1);
                char sChar = str.charAt(j - 1);

                if (pChar == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (pChar == '?' || pChar == sChar) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[pLen][sLen] ? 1 : 0;
    }
}
