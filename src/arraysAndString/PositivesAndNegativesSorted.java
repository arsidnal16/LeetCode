package arraysAndString;

import java.util.Arrays;

public class PositivesAndNegativesSorted {
	
	public static void main(String args[]) {
		int arr[] = {2, -3, 4, 5, 6,-34, -21, -52, 23, 34, -9, -99};
	//	int[] ret = sortPositiveAndNegatives2(arr);
		
		
		RearrangePosNeg(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	
	/* Function to reverse an array. An array can be
	reversed in O(n) time and O(1) space. */
	void reverse(int arr[], int l, int r)
	{
	    if (l < r)
	    {
	        swap(arr, arr[l], arr[r]);
	        reverse(arr, ++l, --r);
	    }
	}
	 
	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	void merge(int arr[], int l, int m, int r)
	{
	    int i = l; // Initial index of 1st subarray
	    int j = m + 1; // Initial index of IInd
	 
	    while (i <= m && arr[i] < 0)
	        i++;
	 
	    // arr[i..m] is positive
	 
	    while (j <= r && arr[j] < 0)
	        j++;
	 
	    // arr[j..r] is positive
	 
	    // reverse positive part of left sub-array (arr[i..m])
	    reverse(arr, i, m);
	 
	    // reverse negative part of right sub-array (arr[m+1..j-1])
	    reverse(arr, m + 1, j - 1);
	 
	    // reverse arr[i..j-1]
	    reverse(arr, i, j - 1);
	}
	 
	// Function to Rearrange positive and negative
	// numbers in a array
	void RearrangePosNeg(int arr[], int l, int r)
	{
	    if (l < r)
	    {
	        // Same as (l+r)/2, but avoids overflow for
	        // large l and h
	        int m = l + (r - l) / 2;
	 
	        // Sort first and second halves
	        RearrangePosNeg(arr, l, m);
	        RearrangePosNeg(arr, m + 1, r);
	 
	        merge(arr, l, m, r);
	    }
	}
	
	public static void RearrangePosNeg(int arr[])
	{
		
		/*
		 * Loop from i = 1 to n - 1.
  a) If the current element is positive, do nothing.
  b) If the current element arr[i] is negative, we 
     insert it into sequence arr[0..i-1] such that 
     all positive elements in arr[0..i-1] are shifted 
     one position to their right and arr[i] is inserted
     at index of first positive element.
		 */
	    int key, j;
	    for(int i = 1; i < arr.length; i++)
	    {
	        key = arr[i];
	 
	        // if current element is positive
	        // do nothing
	        if (key > 0)
	            continue;
	 
	        /* if current element is negative,
	        shift positive elements of arr[0..i-1],
	        to one position to their right */
	        j = i - 1;
	        while (j >= 0 && arr[j] > 0)
	        {
	            arr[j + 1] = arr[j];
	            j = j - 1;
	        }
	 
	        // Put negative element at its right position
	        arr[j + 1] = key;
	    }
	}

	private static int[] sortPositiveAndNegatives(int[] arr) {
		
		int low =0;
		int high = arr.length -1;
		
		while(low < high) {
			
			if(arr[low] < 0) low++;
			if(arr[high] > 0) high--;  
			
			if(arr[low] > 0 && arr[high] < 0) {
				swap(arr, low,high);
				low++;
				high--;
			}
		}
		
		return arr;
		
	}

	private static void swap(int[] arr, int low, int high) {
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
		
	}
	
	
	private static int[] sortPositiveAndNegatives2(int[] arr) {
		
		int[] result = new int[arr.length];
		
		int i = 0;
		int pos = 0;
		while(i< arr.length) {
			if(arr[i] < 0) {
				result[pos] = arr[i];
				pos++;
			}
			i++;
		}
		
		i = 0;
		
		while(i< arr.length) {
			if(arr[i] > 0) {
				result[pos] = arr[i];
				pos++;
			}
			i++;
		}
		
		
		return result;
		
		
	}

}
