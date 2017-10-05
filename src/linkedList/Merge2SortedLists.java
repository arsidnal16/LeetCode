package linkedList;
public class Merge2SortedLists {
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0);
        ListNode result = p;
        
        while(l1 != null && l2!= null){
            int x = l1.val;
            int y = l2.val;
            
            if(x<y){
                result.next = l1;
                l1 = l1.next;
            }
            else{
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
            
        }
        
        if(l1!=null){
            result.next = l1;
        }
        
        if(l2!=null){
            result.next = l2;
        }
        
       return p.next; 
    }


}
