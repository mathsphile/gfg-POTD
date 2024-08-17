// Given an array nums[], construct a Product Array nums[] such that nums[i] is equal to the product of all the elements of nums except nums[i].

class Solution {
    public static long[] productExceptSelf(int nums[]) {
        int n = nums.length;
        long[] result = new long[n];

        // Initialize the result array as 1 (to multiply with later values)
        for (int i = 0; i < n; i++) {
            result[i] = 1;
        }

        // Temp variable to store the product of elements to the left of nums[i]
        long leftProduct = 1;
        for (int i = 0; i < n; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }

        // Temp variable to store the product of elements to the right of nums[i]
        long rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}