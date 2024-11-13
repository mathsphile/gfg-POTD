//Given two singly linked lists, return the point where two linked lists intersect.

// Note: If the linked lists do not merge at any point, return -1.
class Intersect {
    // Function to find the intersection point in Y shaped Linked Lists.
    int intersectPoint(Node head1, Node head2) {
        if (head1 == null || head2 == null)
            return -1;

        Node ptr1 = head1;
        Node ptr2 = head2;

        // Traverse both lists. When a pointer reaches the end, switch to the other
        // head.
        while (ptr1 != ptr2) {
            ptr1 = (ptr1 == null) ? head2 : ptr1.next;
            ptr2 = (ptr2 == null) ? head1 : ptr2.next;
        }

        // If they intersect, ptr1 (or ptr2) will point to the intersection node.
        // If they don’t intersect, both pointers will eventually be null.
        return (ptr1 != null) ? ptr1.data : -1;
    }
}
