package arraysAndString;


/*
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 */
public class SortColors {

/*	My java version is more readable, the basic idea is to use two pointer low and high and an iterator i

	every elem left low pointer is 0, elem right high pointer is 2
*/
	   public void sortColors(int[] A) {
	       if(A==null || A.length<2) return;
	       int low = 0; 
	       int high = A.length-1;
	       for(int i = low; i<=high;) {
	           if(A[i]==0) {
	              // swap A[i] and A[low] and i,low both ++
	              int temp = A[i];
	              A[i] = A[low];
	              A[low]=temp;
	              i++;low++;
	           }else if(A[i]==2) {
	               //swap A[i] and A[high] and high--;
	              int temp = A[i];
	              A[i] = A[high];
	              A[high]=temp;
	              high--;
	           }else {
	               i++;
	           }
	       }
	   }
}
