package designlinkedlist;

public class MyLinkedList {

	class ListNode {
		int val;
		ListNode next;
	}

	private ListNode head;

	/** Initialize your data structure here. */
	public MyLinkedList() {

	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {
		if (this.head == null) {
			return -1;
		}
		if (index < 0) {
			return -1;
		}
		ListNode node = this.head;
		for (int i = 0; i < index; i++) {
			if (node == null) {
				return -1;
			} else {
				node = node.next;
			}
		}
		if (node == null) {
			return -1;
		}
		return node.val;

	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		ListNode listNode = new ListNode();
		listNode.val = val;
		if (this.head == null) {
			this.head = listNode;
			return;
		}
		listNode.next = this.head;
		this.head = listNode;
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		ListNode listNode = new ListNode();
		listNode.val = val;
		if (this.head == null) {
			this.head = listNode;
			return;
		}

		ListNode node = this.head;
		while (node.next != null) {
			node = node.next;
		}
		node.next = listNode;
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted.
	 */
	public void addAtIndex(int index, int val) {
		ListNode insertNode = new ListNode();
		insertNode.val = val;
		if (this.head == null && index == 0) {
			this.head = insertNode;
			return;
		}
		if (index <= 0) {
			insertNode.next = this.head;
			this.head = insertNode;
		}
		ListNode listNode = this.head;
		for (int i = 0; i < index - 1; i++) {
			listNode = listNode.next;
			if (listNode == null) {
				return;
			}
		}
		if (listNode == null) {
			return;
		}
		insertNode.next = listNode.next;
		listNode.next = insertNode;
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if (this.head == null) {
			return;
		}
		if (index == 0) {
			this.head = this.head.next;
			return;
		}
		if (index < 0) {
			return;
		}
		ListNode node = this.head;
		for (int i = 0; i < index - 1; i++) {
			node = node.next;
			if (node == null) {
				return;
			}
		}
		if (node.next == null) {
			return;
		}
		node.next = node.next.next;
	}
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList(); int param_1 = obj.get(index);
 * obj.addAtHead(val); obj.addAtTail(val); obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */