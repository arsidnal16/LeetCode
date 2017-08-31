
public class ProductExceptItself {
	
	
	/*
	 * 
	 * /*
 * nums   = [1, 2, 3, 4]
 * output = product of nums[left of i] * product of nums[right of i]
 *
output = [
  24, // left: init=1     nums[i]=1  right: 2 * 3 * 4 
  12, // left: 1          nums[i]=2  right: 3 * 4
  8,  // left: 1 * 2      nums[i]=3  right: 4
  6,  // left: 1 * 2 * 3  nums[i]=4  right: init=1 
				]
	 * 
	 * 
	 */
	
	//Use tmp to store temporary multiply result by two directions. Then fill it into result. Bingo!

	public int[] productExceptSelf(int[] nums) {
	    int[] result = new int[nums.length];
	    for (int i = 0, tmp = 1; i < nums.length; i++) {
	        result[i] = tmp;
	        tmp *= nums[i];
	    }
	    for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
	        result[i] *= tmp;
	        tmp *= nums[i];
	    }
	    return result;
	}

}
