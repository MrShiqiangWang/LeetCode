package pkg202007;

import utils.ListHelper;
import utils.ListNode;

public class L83 {

    public static void main(final String[] args) {
        System.out.println(new L83().deleteDuplicates(ListHelper.stringToListNode("[1,1,1]")));
    }

    public ListNode deleteDuplicates(final ListNode head) {
        ListNode node = head;
        while (node != null) {
            if (node.next != null && node.next.val == node.val) {
                node.next = node.next.next;
                node = node.next;
            }
            else {
                node = node.next;
            }
        }
        return head;
    }
}
