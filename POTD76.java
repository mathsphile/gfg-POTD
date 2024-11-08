// Given two strings s1 and s2. Return a minimum number of times s1 has to be repeated such that s2 is a substring of it. If s2 can never be a substring then return -1.

// Note: Both the strings contain only lowercase letters.

class Solution {
    static int minRepeats(String s1, String s2) {
        // Initial repeated string
        StringBuilder repeated = new StringBuilder(s1);
        int count = 1;
        
        // Repeat until the length of repeated is at least as long as s2 or we find s2
        while (repeated.length() < s2.length()) {
            repeated.append(s1);
            count++;
        }
        
        // Check if s2 is a substring in the current repeated string
        if (repeated.indexOf(s2) != -1) {
            return count;
        }
        
        // Add one more repeat and check again (as s2 might overlap between repeats)
        repeated.append(s1);
        count++;
        
        // Final check for substring
        if (repeated.indexOf(s2) != -1) {
            return count;
        }
        
        // If s2 is still not a substring, return -1
        return -1;
    }
}
