package Hash;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LengthOfLongestContainedInterval {
	
	public int longestContainedRange(List<Integer> A) {
	Set<Integer> unprocessedEntries =  new HashSet<>(A);
	
	int maxIntervalSize =0;
	
	while(!unprocessedEntries.isEmpty()) {
		int a = unprocessedEntries.iterator().next();
		unprocessedEntries.remove(a);
		
		int lowerBound = a-1;
		
		while(unprocessedEntries.contains(lowerBound)) {
			unprocessedEntries.remove(lowerBound);
			lowerBound--;
		}
		
		int upperBound = a+1;
		
		while(unprocessedEntries.contains(upperBound)) {
			unprocessedEntries.remove(upperBound);
			upperBound++;
		}
		
		maxIntervalSize = Math.max(maxIntervalSize, upperBound - lowerBound -1);
		
	}
	
	return maxIntervalSize;
	
	
	}
}
