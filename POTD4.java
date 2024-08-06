// Given a binary tree, return an array where elements represent the bottom view of the binary tree from left to right.

// Note: If there are multiple bottom-most nodes for a horizontal distance from the root, then the latter one in the level traversal is considered. For example, in the below diagram, 3 and 4 are both the bottommost nodes at a horizontal distance of 0, here 4 will be considered.



class Solution {
    // Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // Map to store the bottommost node at each horizontal distance
        Map<Integer, Integer> map = new TreeMap<>();
        // Queue for BFS, storing nodes and their horizontal distance
        Queue<Pair> queue = new LinkedList<>();

        // Initialize the queue with the root node and horizontal distance 0
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            Node currentNode = currentPair.node;
            int hd = currentPair.hd;

            // Overwrite the map entry for each horizontal distance
            map.put(hd, currentNode.data);

            // Add the left and right children to the queue with updated horizontal
            // distances
            if (currentNode.left != null) {
                queue.add(new Pair(currentNode.left, hd - 1));
            }
            if (currentNode.right != null) {
                queue.add(new Pair(currentNode.right, hd + 1));
            }
        }

        // Collecting the bottom view from the map
        for (Integer value : map.values()) {
            result.add(value);
        }

        return result;
    }
}

// Helper class to store a node and its horizontal distance
class Pair {
    Node node;
    int hd;

    public Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}
 