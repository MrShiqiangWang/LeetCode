package pkg202007;

import java.util.List;

import history.pkg201906.DeleteNode;
import utils.ListNode;

public class L203 {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		// 保证head不是val
		while (head != null && head.val == val) {
			head = head.next;
		}
		// 从head开始向下删除数据
		ListNode node = head;
		while (node != null) {
			if (node.next != null && node.next.val == val) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}

		return head;
	}
}
