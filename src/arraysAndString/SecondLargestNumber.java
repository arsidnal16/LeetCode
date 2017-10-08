package arraysAndString;

public class SecondLargestNumber {
	
	public void getSecondLargest(int[] arr) {
		
		
	      
        /* There should be atleast two elements */
        if (arr.length < 2)
        {
            System.out.print(" Invalid Input ");
            return;
        }
      
        int first =  Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        
        for (int a : arr)
        {
            /* If current element is smaller than 
            first then update both first and second */
            if (a > first)
            {
                second = first;
                first = a;
            }
      
            /* If arr[i] is in between first and 
               second then update second  */
            else if (a > second && a != first)
                second = a;
        }
         
        if (second == Integer.MIN_VALUE)
             System.out.print("There is no second largest"+
                                 " element\n");
        else
             System.out.print("The second largest element"+
                                      " is "+ second);
	}

}
