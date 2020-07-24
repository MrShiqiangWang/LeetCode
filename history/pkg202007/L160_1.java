package history.pkg202007;

import utils.ListNode;

public class L160_1 {

    public ListNode getIntersectionNode(final ListNode headA, final ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            if (nodeA == null) {
                nodeA = headB;
            }
            else {
                nodeA = nodeA.next;
            }
            if (nodeB == null) {
                nodeB = headA;

            }
            else {
                nodeB = nodeB.next;
            }
        }
        return nodeA;
    }
}
