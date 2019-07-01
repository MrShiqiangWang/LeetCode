package package_in_201906;

public class AddTwoNumbers {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode node = null;
		ListNode root = null;
		int increment = 0;
		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {
				int value = l1.val + l2.val + increment;
				if (value >= 10) {
					value = value - 10;
					increment = 1;
				} else {
					increment = 0;
				}
				if (node == null) {
					node = new ListNode(value);
					root = node;
				} else {
					ListNode node2 = new ListNode(value);
					node.next = node2;
					node = node2;
				}
			} else if (l1 == null && l2 != null) {
				int value = l2.val + increment;
				if (value >= 10) {
					value = value - 10;
					increment = 1;
				} else {
					increment = 0;
				}
				if (node == null) {
					node = new ListNode(value);
					root = node;
				} else {
					ListNode node2 = new ListNode(value);
					node.next = node2;
					node = node2;
				}
			} else {
				int value = l1.val + increment;
				if (value >= 10) {
					value = value - 10;
					increment = 1;
				} else {
					increment = 0;
				}
				if (node == null) {
					node = new ListNode(value);
					root = node;
				} else {
					ListNode node2 = new ListNode(value);
					node.next = node2;
					node = node2;
				}
			}
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (increment == 0) {
			return root;
		} else {
			ListNode listNode = new ListNode(increment);
			node.next = listNode;
			return root;
		}
	}
}
