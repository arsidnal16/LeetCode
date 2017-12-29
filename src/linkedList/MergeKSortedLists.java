package linkedList;

import linkedList.OddEvenLinkedList.ListNode;

public class MergeKSortedLists {
	
	//Use divide and conquer
	public static ListNode mergeKLists(ListNode[] lists){
	    return partion(lists,0,lists.length-1);
	}
	
	public static ListNode partion(ListNode[] lists,int s,int e){
	    if(s==e)  return lists[s];
	    if(s<e){
	        int q=(s+e)/2;
	        ListNode l1=partion(lists,s,q);
	        ListNode l2=partion(lists,q+1,e);
	        return merge(l1,l2);
	    }else
	        return null;
	}
	
	//This function is from Merge Two Sorted Lists.
	public static ListNode merge(ListNode l1,ListNode l2){
	    if(l1==null) return l2;
	    if(l2==null) return l1;
	    if(l1.val<l2.val){
	        l1.next=merge(l1.next,l2);
	        return l1;
	    }else{
	        l2.next=merge(l1,l2.next);
	        return l2;
	    }
	}
	
	
	
	
public ListNode mergeKLists2(ListNode[] arr) {
        
        if(arr.length == 0){
            return null;
        }
		int last = arr.length -1;
	    // repeat until only one list is left
	    while (last != 0)
	    {
	        int i = 0, j = last;
	 
	        // (i, j) forms a pair
	        while (i < j)
	        {
	            // merge List i with List j and store
	            // merged list in List i
	            arr[i] = SortedMerge(arr[i], arr[j]);
	 
	            // consider next pair
	            i++;
	            j--;
	 
	            // If all pairs are merged, update last
	            if (i >= j)
	                last = j;
	        }
	    }
	 
	    return arr[0];
	}
    
    ListNode SortedMerge(ListNode a, ListNode b)
	{
		ListNode result = null;
	 
	    /* Base cases */
	    if (a == null)
	        return (b);
	    else if(b == null)
	        return (a);
	 
	    /* Pick either a or b, and recur */
	    if(a.val <= b.val)
	    {
	        result = a;
	        result.next = SortedMerge(a.next, b);
	    }
	    else
	    {
	        result = b;
	        result.next = SortedMerge(a, b.next);
	    }
	 
	    return result;
	}
}

