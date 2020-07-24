package history.pkg202007;

import utils.ListNode;

public class L1290 {

    public static void main(final String[] args) {
        final ListNode listNode = new ListNode(1);
        final ListNode listNode2 = new ListNode(0);
        final ListNode listNode3 = new ListNode(1);
        listNode.next = listNode2;
        listNode2.next = listNode3;

        System.out.println(new L1290().getDecimalValue(listNode));
    }

    public int getDecimalValue(final ListNode head) {
        if (head == null) {
            return -1;
        }
        ListNode node = head;
        final StringBuilder builder = new StringBuilder();
        do {
            builder.append(node.val + "");
            node = node.next;
        }
        while (node != null);
        return Integer.valueOf(builder.toString(), 2).intValue();
    }
}
