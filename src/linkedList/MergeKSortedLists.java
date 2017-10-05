package linkedList;
public class MergeKSortedLists {

	
    public ListNode mergeKLists(ListNode[] arr) {
        
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
