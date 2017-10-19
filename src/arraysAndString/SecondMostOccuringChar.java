package arraysAndString;

public class SecondMostOccuringChar {
	
	//static final int NO_OF_CHARS = 256;
	
	
	 static char getSecondMostFreq(String str)
	    {
	        // count number of occurrences of every character. 
	        int[] count = new int[256];
	        for (int i=0; i< str.length(); i++)
	            (count[str.charAt(i)])++;
	      
	        // Traverse through the count[] and find
	        // second highest element.
	        int first = 0, second = 0;
	        for (int i = 0; i < str.length(); i++)
	        {
	            /* If current element is smaller than
	            first then update both first and second */
	            if (count[i] > count[first])
	            {
	                second = first;
	                first = i;
	            }
	      
	            /* If count[i] is in between first and
	            second then update second  */
	            else if (count[i] > count[second] &&
	                     count[i] != count[first])
	                second = i;
	        }
	      
	        return (char)second;
	    }
	      
}

