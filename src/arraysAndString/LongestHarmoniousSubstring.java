package arraysAndString;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubstring {
	
	
	/*
	 * 
	 * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

Example 1:
Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].
	 */
	
	public int findLHS(int[] nums) {
	    Map<Long, Integer> map = new HashMap<>();
	    for (long num : nums) {
	        map.put(num, map.getOrDefault(num, 0) + 1);
	    }
	    int result = 0;
	    for (long key : map.keySet()) {
	        if (map.containsKey(key + 1)) {
	            result = Math.max(result, map.get(key + 1) + map.get(key));
	        }
	    }
	    return result;
	}

}
