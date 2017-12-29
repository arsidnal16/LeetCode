package linkedList;

import java.util.HashSet;

public class RemoveDuplicates {

	static class node {
		int val;
		node next;

		public node(int val) {
			this.val = val;
		}
	}

	/*
	 * Function to remove duplicates from a unsorted linked list
	 * 
	 * We can also use 2 pointers and remove duplicates without extra space but time complexity will be O(n^2)
	 */
	static void removeDuplicate(node head) {
		HashSet<Integer> hs = new HashSet<>();

		/* Pick elements one by one */
		node current = head;
		node prev = null;
		while (current != null) {
			int curval = current.val;

			// If current value is seen before
			if (hs.contains(curval)) {
				prev.next = current.next;
			} else {
				hs.add(curval);
				prev = current;
			}
			current = current.next;
		}

	}

}
