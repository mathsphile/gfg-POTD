// Given a positive integer n. You have to find nth natural number after removing all the numbers containing the digit 9.

public class Solution {
    long findNth(long n) {
         long result = 0;
        long base = 1;

        while (n > 0) {
            result += (n % 9) * base;
            n /= 9;
            base *= 10;
        }

        return result;
    }
} 