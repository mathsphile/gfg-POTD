// Given a string s consisting of lowercase Latin Letters. Return the first non-repeating character in s. If there is no non-repeating character, return '$'.
// Note: When you return '$' driver code will output -1.

public class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Create an array to store the frequency of each character.
        int[] freq = new int[26];
        
        // Traverse the string to count the frequency of each character.
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Traverse the string again to find the first non-repeating character.
        for (char c : s.toCharArray()) {
            if (freq[c - 'a'] == 1) {
                return c;
            }
        }
        
        // If no non-repeating character is found, return '$'.
        return '$';
    }
}

