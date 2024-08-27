// Given an integer array arr of integers, the task is to find the maximum absolute difference between the nearest left smaller element and the nearest right smaller element of every element in array arr. If for any component of the arr, the nearest smaller element doesn't exist then consider it as 0.


class Solution {
    public int findMaxDiff(int[] arr) {
        int n = arr.length;

        // Arrays to store the nearest smaller elements to the left and right
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Fill leftSmaller array
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            leftSmaller[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(arr[i]);
        }

        stack.clear(); // Clear the stack to reuse it for the right side

        // Fill rightSmaller array
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            rightSmaller[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(arr[i]);
        }

        // Calculate the maximum absolute difference
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(leftSmaller[i] - rightSmaller[i]));
        }

        return maxDiff;
    }
}
