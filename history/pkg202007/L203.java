package history.pkg202007;

import utils.ListNode;

public class L203 {

    public ListNode removeElements(ListNode head, final int val) {
        if (head == null) {
            return null;
        }
        // ��֤head����val
        while (head != null && head.val == val) {
            head = head.next;
        }
        // ��head��ʼ����ɾ������
        ListNode node = head;
        while (node != null) {
            if (node.next != null && node.next.val == val) {
                node.next = node.next.next;
            }
            else {
                node = node.next;
            }
        }

        return head;
    }
}
