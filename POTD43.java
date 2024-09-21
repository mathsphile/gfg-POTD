// You are given a special linked list where each node has a next pointer pointing to its next node.You are also given some random pointers,where you will be given some pairs denoting two nodes a and b i.e.a->random=b(random is a pointer to a random node).

// Construct a copy of the given list.The copy should consist of the same number of new nodes,where each new node has its value set to the value of its corresponding original node.Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the original and copied list pointers represent the same list state.None of the pointers in the new list should point to nodes in the original list.

// For example,if there are two nodes x and y in the original list,where x->random=y,then for the corresponding two nodes xnew and ynew in the copied list,xnew->random=ynew.

// Return the head of the copied linked list.

// NOTE:1. If there is any node whose arbitrary pointer is not given then it'sby default NULL.2. Don'tmake any changes to the original linked list.

class Solution {
    // Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        if (head == null) return null;

        // Step 1: Create new nodes and interleave them with original nodes
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.data);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // Step 2: Set random pointers for the new nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Restore original list and extract the copied list
        Node original = head, copy = head.next;
        Node copyHead = copy;
        while (original != null) {
            original.next = original.next.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            original = original.next;
            copy = copy.next;
        }

        return copyHead;
    }
}
