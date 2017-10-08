package linkedList;

public class RemoveNthFromLinkedList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		// If list does not exist or if there are no elements in the list,return NULL
		if (head == null || n < 1) {
			return null;
		}

		// make pointers p1 and p2 point to the start of the list.
		ListNode p1 = head;
		ListNode p2 = head;
		for (int j = 0; j < n; ++j) { // make then n nodes apart.

			// while moving p2 check if it becomes NULL, that is if it reaches the end
			// of the list. That would mean the list has less than n nodes, so its not
			// possible to find nth from last, so return NULL.
			if (p2 == null) {
				return null;
			}
			p2 = p2.next;
		}
		while (p2 != null) { // move till p2 goes past the end of the list.
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;

	}

}
