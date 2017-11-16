package arraysAndString;
import java.util.Arrays;

public class RotateArrays {
	
	public static void main(String args[]) {
		int[] arr = {0,1,2,3,4,5,6};
		rotate(arr, 2);
		System.out.println(Arrays.toString(arr));
		rotate(arr, 3);
		System.out.println(Arrays.toString(arr));
		rotate(arr, 4);
		System.out.println(Arrays.toString(arr));
		rotate(arr, 5);
		System.out.println(Arrays.toString(arr));
		
	}
	
	
	
	/*
	 * The basic idea is that, for example, nums = [1,2,3,4,5,6,7] and k = 3, 
	 * first we reverse [1,2,3,4], it becomes[4,3,2,1]; 
	 * then we reverse[5,6,7], it becomes[7,6,5], 
	 * finally we reverse the array as a whole, it becomes[4,3,2,1,7,6,5] ---> [5,6,7,1,2,3,4].

		Reverse is done by using two pointers, one point at the head and the other point at the tail, 
		after switch these two, these two pointers move one position towards the middle.
	 * 
	 * 
	 */
	
	public static int[] rotate(int[] nums, int k) {
		if(nums == null || nums.length < 2){
	        return nums;
	    }
	    
		int n = nums.length;
	    k = k % n;
	    reverse(nums, 0, n - 1);
	    reverse(nums, 0, k - 1);
	    reverse(nums, k, n - 1);
	    
	    
	    return nums;
	}

	private static void reverse(int[] nums, int i, int j){
	    int tmp = 0;       
	    while(i < j){
	        tmp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = tmp;
	        i++;
	        j--;
	    }
	}

}
