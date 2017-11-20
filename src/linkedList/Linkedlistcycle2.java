package linkedList;

public class Linkedlistcycle2 {
	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return head;

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow) {
				 slow = head;
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;  // slow is the start of the cycle
			}
		}
		return null;
	}
}
