package pkg202007;

import java.util.HashSet;
import java.util.Set;

import utils.ListNode;

public class L141 {

    public boolean hasCycle(ListNode head) {
        final Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            else {
                set.add(head);
                head = head.next;
            }
        }
        return false;

    }
}
