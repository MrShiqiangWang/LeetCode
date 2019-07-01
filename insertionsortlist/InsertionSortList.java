package insertionsortlist;

public class InsertionSortList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		ListNode listNode = new ListNode(4);
		ListNode node = new ListNode(1);
		listNode.next = node;
		System.out.println(new InsertionSortList().insertionSortList(listNode));
	}

	public ListNode insertionSortList(ListNode head) {

		ListNode node = head;
		while (node != null) {
			//
			ListNode p = head;
			boolean nextNull = false;
			if (node.next == null) {
				nextNull = true;
			}
			while (p.next != null && p.next.val < node.val) {

				node.next = p.next;
				p.next = node;
				p = p.next;
				if (nextNull) {
					p.next = null;
				}
			}
			node = node.next;
		}
		return head;
	}
}
