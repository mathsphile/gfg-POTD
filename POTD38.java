// Given a Binary Tree(BT),convert it to a Doubly Linked List(DLL)in place.The left and right pointers in nodes will be used as previous and next pointers respectively in converted DLL.The order of nodes in DLL must be the same as the order of the given Binary Tree.The first node of Inorder traversal(leftmost node in BT)must be the head node of the DLL.

// Note:h is the tree'sheight,and this space is used implicitly for the recursion stack.

class Solution
{
    Node prev = null;
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
	 
      // Base case: If the root is null, return null
        if (root == null) return null;

        // Recursively convert the left subtree
        Node head = bToDLL(root.left);

        // If this is the leftmost node, it becomes the head of the DLL
        if (prev == null) {
            head = root;
        } else {
            // Connect the previous node with the current node
            prev.right = root;
            root.left = prev;
        }

        // Update the previous node to the current node
        prev = root;

        // Recursively convert the right subtree
        bToDLL(root.right);

        return head;
    }
}