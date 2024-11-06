// Given a binary tree, where every node value is a number. Find the sum of all the numbers that are formed from root to leaf paths. The formation of the numbers would be like 10*parent + current (see the examples for more clarification).
class Solution {
    public static int treePathsSum(Node root) {
        return calculatePathSum(root, 0);
    }

    private static int calculatePathSum(Node node, int currentSum) {
        if (node == null) {
            return 0;
        }

        // Update the current path sum by including the current node's value
        currentSum = 10 * currentSum + node.data;

        // If we reached a leaf node, return the current path sum
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // Recurse for left and right subtrees and sum the path sums
        int leftSum = calculatePathSum(node.left, currentSum);
        int rightSum = calculatePathSum(node.right, currentSum);

        return leftSum + rightSum;
    }
}
