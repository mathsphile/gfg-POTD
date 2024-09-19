// Given a String str, reverse the string without reversing its individual words. Words are separated by dots.

// Note: The last character has not been '.'. 

class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String str) {
        // Split the string into words using the split() method
        String[] words = str.split("\\.");

        // Reverse the order of the words using the reverse() method
        Collections.reverse(Arrays.asList(words));

        // Join the reversed words back into a string using the join() method
        StringBuilder reversedStr = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            reversedStr.append(words[i]);
            if (i < words.length - 1) {
                reversedStr.append(".");
            }
        }

        return reversedStr.toString();
    }
}