package pkg202007;

public class L82 {

    public ListNode deleteDuplicates(final ListNode head) {

        ListNode first = head;
        ListNode second = head;

        while (first.next != null) {
            if (first.next != null && first.next.next != null && first.next.val == first.next.next.val) {
                second = first.next.next;
                while (second.next != null) {
                    if (second.next.val == second.val) {
                        second = second.next;
                    }
                    else {
                        break;
                    }
                }
                first.next = second.next;
            }
            else {
                first = first.next;
            }
        }
        return head;
    }
}
