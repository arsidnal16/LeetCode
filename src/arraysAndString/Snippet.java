package arraysAndString;


import java.util.Arrays;


public class Snippet {
	static char[] reverseWords(char[] arr) {
	    
	    
		// reverse all characters:
		    int n = arr.length;
		    mirrorReverse(arr, 0, n-1);
		    
		    System.out.println(arr);

		   // reverse each word:
		    int wordStart = 0;
		    for (int i= 0 ; i < n-1; i ++) {
		   // 	System.out.println(arr[i]);
		        if (arr[i] == ' ') {
		            if (wordStart != 0) {
		                mirrorReverse(arr, wordStart, i-1);
		                System.out.println(arr);
		                wordStart = 0;
		            }
		        }
		        else if (i == n-1) {
		            if (wordStart != 0) {
		                mirrorReverse(arr, wordStart, i);
		            }
		        }
		        else {
		            if (wordStart == 0) {
		                wordStart = i;
		            }
		        }
		      
		    }
		    return arr;

	}
		// helper function - reverses the order of items in arr
	
		// if are arrays sent by value, reversing should be done in place

		public static char[] mirrorReverse(char[] arr, int start, int end) {
		    
		    while (start < end) {
		       char  tmp = arr[start];
		        arr[start] = arr[end];
		        arr[end] = tmp;
		        start++;
		        end--;
		    }
		return arr;
	}
	
	public static void main(String args[]) {
		char[] dummy = { 'a', ' ', 'b'};
		char[] arr = { 'p', 'e', 'r', 'f', 'e', 'c', 't', ' ',
                'm', 'a', 'k', 'e', 's', ' ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' };
		System.out.print(Arrays.toString(reverseWords(dummy)));
		System.out.println(Arrays.toString(reverseWords(arr)));
		
	}
	
	
}

