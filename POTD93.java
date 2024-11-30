// Given two strings s1 and s2 consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, act and tac are an anagram of each other. Strings s1 and s2 can only contain lowercase alphabets.

// Note: You can assume both the strings s1 & s2 are non-empty.Given two strings s1 and s2 consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, act and tac are an anagram of each other. Strings s1 and s2 can only contain lowercase alphabets.

// Note: You can assume both the strings s1 & s2 are non-empty.

class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) {
        // Check if lengths are not equal, they can't be anagrams
        if (s1.length() != s2.length()) {
            return false;
        }

        // Create a frequency array for counting characters (assuming only lowercase letters)
        int[] charCount = new int[26];

        // Increment count for characters in s1 and decrement for characters in s2
        for (int i = 0; i < s1.length(); i++) {
            charCount[s1.charAt(i) - 'a']++;
            charCount[s2.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        // If all counts are zero, the strings are anagrams
        return true;
    }
}
