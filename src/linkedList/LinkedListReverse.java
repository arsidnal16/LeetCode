package linkedList;

public class LinkedListReverse {
	
	class Node {
	      int val;
	      Node next;
	      Node(int x) {
	          val = x;
	          next = null;
	      }
	  }
	
	/* Function to reverse the linked list */
    Node reverse(Node head) {
    		Node prev = null;
		while (head != null) {
			Node next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
    }
 

}
