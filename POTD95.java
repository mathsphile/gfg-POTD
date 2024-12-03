// Given a string s, the task is to find the minimum characters to be added at the front to make the string palindrome.
// Note: A palindrome string is a sequence of characters that reads the same forward and backward. fill in the blanks class Solution {
class Solution {
    public static int minChar(String A) {
        String rev = new StringBuilder(A).reverse().toString();
        String concat = A + "$" + rev;
        int[] lps = new int[concat.length()];
        int y = 0;
        for (int x = 1; x < concat.length(); x++) {
            while (y > 0 && concat.charAt(x) != concat.charAt(y)) {
                y = lps[y - 1];
            }
            if (concat.charAt(x) == concat.charAt(y)) {
                y++;
            }
            lps[x] = y;
        }
        return A.length() - lps[concat.length()-1];
   }
}