// Given two binary strings s1 and s2 consisting of only 0s and 1s. Find the resultant string after adding the two Binary Strings.
// Note: The input strings may contain leading zeros but the output string should not have any leading zeros.



class Solution {
    public String addBinary(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        int i = s1.length() - 1, j = s2.length() - 1, carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += s1.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += s2.charAt(j--) - '0';
            }
            result.append(sum % 2); // Append the current bit (sum % 2)
            carry = sum / 2; // Update carry
        }

        if (carry != 0) {
            result.append(carry); // Append final carry if it exists
        }

        // Reverse and remove leading zeros
        String output = result.reverse().toString();
        int idx = 0;

        // Remove leading zeros
        while (idx < output.length() && output.charAt(idx) == '0') {
            idx++;
        }

        // Return the result without leading zeros or "0" if the result is empty
        return idx < output.length() ? output.substring(idx) : "0";
    }
}
