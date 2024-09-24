// Given two strings s and p.Find the smallest window in the string s consisting of all the characters(including duplicates)of the string p.Return"-1"in case there is no such window present.In case there are multiple such windows of same length,return the one with the least starting index.Note:All characters are in Lowercase alphabets.

class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
      if (s.length() < p.length()) {
            return "-1";
        }

        // Frequency map for characters in string p
        HashMap<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        int required = pMap.size(); // Number of unique characters in p that need to be in the window
        int formed = 0; // To count how many characters have met the required frequency in the current window

        HashMap<Character, Integer> windowMap = new HashMap<>();
        int left = 0, right = 0;
        int[] result = {-1, 0, 0}; // Length of the window, left index, right index

        while (right < s.length()) {
            // Add the current character from s to the window
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // If the current character's frequency in the window matches that in pMap, increment formed
            if (pMap.containsKey(c) && windowMap.get(c).intValue() == pMap.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window until it ceases to be 'desirable'
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Save the smallest window that satisfies the condition
                if (result[0] == -1 || right - left + 1 < result[0]) {
                    result[0] = right - left + 1;
                    result[1] = left;
                    result[2] = right;
                }

                // The character at left is no longer part of the window
                windowMap.put(c, windowMap.get(c) - 1);
                if (pMap.containsKey(c) && windowMap.get(c).intValue() < pMap.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return result[0] == -1 ? "-1" : s.substring(result[1], result[2] + 1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "ADOBECODEBANC";
        String p = "ABC";
        System.out.println(sol.smallestWindow(s, p));  // Expected output: "BANC"
    
    }
}