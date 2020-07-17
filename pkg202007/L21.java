package pkg202007;

import utils.ListHelper;
import utils.ListNode;

public class L21 {

    public static void main(final String[] args) {
        System.out.println(new L21().mergeTwoLists(ListHelper.stringToListNode("[1,2,4]"), ListHelper.stringToListNode("[1,3,4]")));
    }

    public ListNode mergeTwoLists(final ListNode l1, final ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode newListNode = null;
        ListNode head = null;
        while (node1 != null || node2 != null) {
            ListNode tmp = null;
            if (node1 != null && node2 != null) {
                if (node1.val <= node2.val) {
                    tmp = node1;
                    node1 = node1.next;
                }
                else {
                    tmp = node2;
                    node2 = node2.next;
                }
            }
            else if (node1 != null) {
                tmp = node1;
                node1 = node1.next;
            }
            else {
                tmp = node2;
                node2 = node2.next;
            }
            if (head == null) {
                head = tmp;
                newListNode = tmp;
            }
            else {
                newListNode.next = tmp;
                newListNode = tmp;
            }
        }
        return head;
    }
}
