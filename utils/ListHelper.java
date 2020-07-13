package utils;

public class ListHelper {

	public static ListNode stringToListNode(String str) {
		int[] array = ArrayHelper.stringToArray(str);
		ListNode head = null;
		ListNode node = null;
		for (int i = 0; i < array.length; i++) {
			if (node != null) {
				node.next = new ListNode(array[i]);
				node = node.next;
			}
			if (head == null) {
				node = new ListNode(array[i]);
				head = node;
			}
		}
		return head;
	}

	public static ListNode revert(ListNode headA) {
		ListNode head = null;
		ListNode curNode = headA;
		while (curNode != null) {
			if (head == null) {
				head = curNode;
				ListNode temp = curNode.next;
				head.next = null;
				curNode = temp;
			} else {
				ListNode temp = curNode.next;
				curNode.next = head;
				head = curNode;
				curNode = temp;
			}
		}
		return head;
	}
}
