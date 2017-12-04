package Hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubarray {
	
	public static int longestSubarraywithdistinctEntries(List<Integer> A) {
		//records the most recent occurrence of each entry
		
		Map<Integer, Integer> mostRecentMap = new HashMap<>();
		int startIndx = 0 ; 
		int result =0;
		
		for(int i =0; i<A.size(); i++) {
			Integer dupIdx = mostRecentMap.put(A.get(i), i);
		// A.get(i) appeared before. Did it appear in the longest current subarray?
			if(dupIdx != null) {
				if(dupIdx >= startIndx) {
					result = Math.max(result, i - startIndx);
					startIndx = dupIdx+1;
				}
			}
		}
		
		return Math.max(result, A.size() - startIndx);
	}

}
