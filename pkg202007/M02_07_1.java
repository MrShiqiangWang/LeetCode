package pkg202007;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.ListHelper;
import utils.ListNode;

public class M02_07_1 {

    public static void main(final String[] args) {
        new M02_07_1().getIntersectionNode(
                ListHelper.stringToListNode("[4,1,8,4,5]"),
                ListHelper.stringToListNode("[5,0,1,8,4,5]"));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        final List<ListNode> nodesA = new ArrayList<>();
        while (headA != null) {
            nodesA.add(headA);
            headA = headA.next;
        }
        final List<ListNode> nodesB = new ArrayList<>();
        while (headB != null) {
            nodesB.add(headB);
            headB = headB.next;
        }
        Collections.reverse(nodesA);
        Collections.reverse(nodesB);
        int i = 0, j = 0;
        for (; i < nodesA.size() && j < nodesB.size(); i++, j++) {
            if (nodesA.get(i).val != nodesB.get(j).val) {
                if (i - 1 >= 0) {
                    return nodesA.get(i - 1);
                }
                return null;
            }
        }
        if (i - 1 < 0) {
            return null;
        }
        if (nodesA.get(i - 1).val == nodesB.get(j - 1).val) {
            return nodesA.get(i - 1);
        }
        return null;
    }

}
