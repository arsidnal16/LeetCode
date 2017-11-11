package arraysAndString;

public class PermutationOfAString {
	
	public static void main(String args[]) {
		permute("america");
	}
	
	
	// Java program to print all permutations of a
	// given string.
	public static void permute(String abc){
		permuteUtil(abc, 0, abc.length()-1);
	}
	
	/**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
	 private static void permuteUtil(String str, int l, int r)
	    {
	        if (l == r)
	            System.out.println(str);
	        else
	        {
	            for (int i = l; i <= r; i++)
	            {
	                str = swap(str,l,i);
	                permuteUtil(str, l+1, r);
	                str = swap(str,l,i);
	            }
	        }
	    }
	 
	    /**
	     * Swap Characters at position
	     * @param a string value
	     * @param i position 1
	     * @param j position 2
	     * @return swapped string
	     */
	    public static String swap(String a, int i, int j)
	    {
	        
	        char[] charArray = a.toCharArray();
	        char temp = charArray[i] ;
	        charArray[i] = charArray[j];
	        charArray[j] = temp;
	        return String.valueOf(charArray);
	    }
	 

}
