//Given a Binary Tree, return Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The ///task is to complete the function leftView(), which accepts root of the tree as argument. If no left view is possible, return an empty tree.


class Tree {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();

            // Traverse all nodes of the current level
            for (int i = 0; i < n; i++) {
                Node node = queue.poll();

                // If this is the first node of the current level
                if (i == 0) {
                    result.add(node.data);
                }

                // Add left node to queue
                if (node.left != null) {
                    queue.add(node.left);
                }

                // Add right node to queue
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return result;

    }
}