// Given a Matrix mat of n*n size. Your task is constructing a 2D linked list representation of the given matrix.

class Solution {
    static Node construct(int arr[][]) {
                int n = arr.length;
        if (n == 0) return null;

        // Create the head of the 2D linked list
        Node[][] nodeArr = new Node[n][n];
        
        // Fill the nodes array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nodeArr[i][j] = new Node(arr[i][j]);
            }
        }
        
        // Link nodes to their right and down neighbors
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n - 1) {
                    nodeArr[i][j].right = nodeArr[i][j + 1];  // Link to the right
                }
                if (i < n - 1) {
                    nodeArr[i][j].down = nodeArr[i + 1][j];  // Link to the down
                }
            }
        }
        
        // Return the head of the linked list
        return nodeArr[0][0];

    }
}