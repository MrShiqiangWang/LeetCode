package history.pkg201906;

public class DeleteNode {

    public class ListNode {

        int val;
        ListNode next;

        ListNode(final int x) {
            this.val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node = node.next.next;
    }
}
