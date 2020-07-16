package pkg202007;

import utils.ListNode;

public class L206 {

	public ListNode reverseList(ListNode head) {
		ListNode curNode = head;
		while (curNode != null) {
			if (curNode == head) {
				curNode = head.next.next;
				ListNode tmp = head.next;
				head.next = null;
				tmp.next = head;
				head = tmp;
			} else {
				ListNode tmp = curNode.next;
				curNode.next = head;
				head = curNode;
				curNode = tmp;
			}
		}
		return head;
	}
}
