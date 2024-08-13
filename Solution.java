// Given an integer n,find the square root of n.If n is not a perfect square,then return the floor value.

// Floor value of any number is the greatest Integer which is less than or equal to that number

public class Solution {
    long floorSqrt(long n) {
        if (n == 0 || n == 1)
            return n;

        long start = 1, end = n, ans = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            // If n is a perfect square
            if (mid * mid == n)
                return mid;

            // Since we need the floor, we update answer when mid*mid is less than n
            if (mid * mid < n) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }
        return ans;

    }
}

