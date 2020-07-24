package history.pkg202007;

import utils.ListNode;

public class M02_07 {

    private class TempNode {

        private final int height;
        ListNode node;

        public TempNode(final int height, final ListNode node) {
            this.height = height;
            this.node = node;
        }
    }

    public ListNode getIntersectionNode(final ListNode headA, final ListNode headB) {
        return this.getNode(headA, headB).node;
    }

    private TempNode getNode(final ListNode headA, final ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        TempNode temp = null;
        if (headA == headB) {
            ListNode node = headA;
            ListNode nodes = headB;
            int i = 0;
            while (node != null) {
                node = node.next;
                nodes = nodes.next;
                if (node != nodes) {
                    temp = null;
                }
                i++;
            }
            if (nodes == null) {
                temp = new TempNode(i, headA);
            }
            else {
                temp = null;
            }
        }
        TempNode node = this.getNode(headA.next, headB);
        if (node != null) {
            if (temp == null) {
                temp = node;
            }
            else {
                if (temp.height < node.height) {
                    temp = node;
                }
            }
        }
        node = this.getNode(headA, headB.next);
        if (node != null) {
            if (temp == null) {
                temp = node;
            }
            else {
                if (temp.height < node.height) {
                    temp = node;
                }
            }
        }
        node = this.getNode(headA.next, headB.next);
        if (node != null) {
            if (temp == null) {
                temp = node;
            }
            else {
                if (temp.height < node.height) {
                    temp = node;
                }
            }
        }
        return node;
    }
}
