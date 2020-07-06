package history.pkg201906;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome {

    class ListNode {

        int val;
        ListNode next;

        ListNode(final int x) {
            this.val = x;
        }
    }

    public boolean isPalindrome(final ListNode head) {
        if (head == null) {
            return true;
        }
        final List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        final int size = list.size();
        final int limit = size / 2;
        for (int i = 0; i < limit; i++) {
            if (list.get(i).val != list.get(size - i - 1).val) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindrome1(final ListNode head) {
        if (head == null) {
            return true;
        }
        final StringBuffer stringBuffer = new StringBuffer();
        ListNode node = head;
        while (node != null) {
            stringBuffer.append(node.val + ",");
            node = node.next;
        }

        node = head;
        ListNode newListHead = null;
        while (node != null) {
            final ListNode tmp = node.next;
            node.next = newListHead;
            newListHead = node;
            node = tmp;
        }

        final StringBuffer stringBuffer1 = new StringBuffer();
        node = newListHead;
        while (node != null) {
            stringBuffer1.append(node.val + ",");
            node = node.next;
        }
        if (stringBuffer.toString().equals(stringBuffer1.toString())) {
            return true;
        }
        return false;

    }
}
