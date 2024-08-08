// Given a Binary Tree. Check for the Sum Tree for every node except the leaf node. Return true if it is a Sum Tree otherwise, return false.
// A SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes present in its left subtree and right subtree. An empty tree is also a Sum Tree as the sum of an empty tree can be considered to be 0. A leaf node is also considered a Sum Tree.

class Solution {
    boolean isSumTree(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        // Recursive case
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        // Check if the current node is a Sum Tree node
        if (root.data == leftSum + rightSum && 
            isSumTree(root.left) && isSumTree(root.right)) {
            return true;
        }

        return false;
    }

    int sum(Node node) {
        // Base case: an empty tree has sum 0
        if (node == null) {
            return 0;
        }

        // Recursively find the sum of the left and right subtrees and add the current node's value
        return sum(node.left) + sum(node.right) + node.data;
    }
}