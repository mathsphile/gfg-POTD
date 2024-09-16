
// Given a string str consisting of opening and closing parenthesis '(' and ')'. Find length of the longest valid parenthesis substring.

// A parenthesis string is valid if:

// For every opening parenthesis, there is a closing parenthesis.
// Opening parenthesis must be closed in the correct order.

class Solution {
    static int maxLength(String S) {
        // Stack to store indices of the parentheses
        Stack<Integer> stack = new Stack<>();
        // Initialize the stack with -1 to handle the base case
        stack.push(-1);
        int maxLength = 0;

        // Traverse the string
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            // If it's an opening parenthesis, push its index onto the stack
            if (c == '(') {
                stack.push(i);
            } else {
                // Pop the top of the stack (which is the matching opening parenthesis)
                stack.pop();

                // If the stack is not empty, calculate the length of the valid substring
                if (!stack.isEmpty()) {
                    maxLength = Math.max(maxLength, i - stack.peek());
                } else {
                    // If the stack is empty, push the current index as a base for the next valid
                    // substring
                    stack.push(i);
                }
            }
        }
        return maxLength;

    }
}