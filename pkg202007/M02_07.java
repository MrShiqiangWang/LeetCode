package pkg202007;

import utils.ListNode;

public class M02_07 {
	private class TempNode {
		private int height;
		ListNode node;

		public TempNode(int height, ListNode node) {
			this.height = height;
			this.node = node;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		return getNode(headA, headB).node;
	}

	private TempNode getNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		TempNode temp = null;
		if (headA == headB) {
			ListNode node = headA;
			ListNode nodes = headB;
			int i = 0;
			while (node != null) {
				node = node.next;
				nodes = nodes.next;
				if (node != nodes) {
					temp = null;
				}
				i++;
			}
			if (nodes == null) {
				temp = new TempNode(i, headA);
			} else {
				temp = null;
			}
		}
		TempNode node = getNode(headA.next, headB);
		if (node != null) {
			if (temp == null) {
				temp = node;
			} else {
				if (temp.height < node.height) {
					temp = node;
				}
			}
		}
		node = getNode(headA, headB.next);
		if (node != null) {
			if (temp == null) {
				temp = node;
			} else {
				if (temp.height < node.height) {
					temp = node;
				}
			}
		}
		node = getNode(headA.next, headB.next);
		if (node != null) {
			if (temp == null) {
				temp = node;
			} else {
				if (temp.height < node.height) {
					temp = node;
				}
			}
		}
		return node;
	}
}
