//Given a binary tree and a node data called target. Find the minimum time required to burn the complete binary tree if the target is set on fire. It is known that in 1 second all nodes connected to a given node get burned. That is its left child, right child, and parent.
//Note: The tree contains unique values.

class Solution {
    /*class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }*/

    public static int minTime(Node root, int target) {
        // Map to store the parent of each node
        Map<Node, Node> parentMap = new HashMap<>();
        Node targetNode = mapParentNodes(root, parentMap, target);

        // Perform BFS from the target node
        return bfsToBurnTree(targetNode, parentMap);
    }

    // Function to map parent nodes and find the target node
    private static Node mapParentNodes(Node root, Map<Node, Node> parentMap, int target) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node targetNode = null;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.data == target) {
                targetNode = currentNode;
            }
            if (currentNode.left != null) {
                parentMap.put(currentNode.left, currentNode);
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                parentMap.put(currentNode.right, currentNode);
                queue.add(currentNode.right);
            }
        }

        return targetNode;
    }

    // BFS to calculate the time taken to burn the tree
    private static int bfsToBurnTree(Node targetNode, Map<Node, Node> parentMap) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        queue.add(targetNode);
        visited.add(targetNode);
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burned = false;

            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();

                // Burn left child
                if (currentNode.left != null && !visited.contains(currentNode.left)) {
                    visited.add(currentNode.left);
                    queue.add(currentNode.left);
                    burned = true;
                }

                // Burn right child
                if (currentNode.right != null && !visited.contains(currentNode.right)) {
                    visited.add(currentNode.right);
                    queue.add(currentNode.right);
                    burned = true;
                }

                // Burn parent node
                if (parentMap.containsKey(currentNode) && !visited.contains(parentMap.get(currentNode))) {
                    visited.add(parentMap.get(currentNode));
                    queue.add(parentMap.get(currentNode));
                    burned = true;
                }
            }

            if (burned) {
                time++;
            }
        }

        return time;
    }
}

