package Hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


class SubArray{
	int start;
	int end;
	
	public SubArray(int start, int end) {
			this.start = start;
			this.end =  end;
	}
	
}

public class SmallestSubarrayCoveringAllValues {
	
	// page 190 elements of prog
	
	
	
	public static SubArray findSmallestSubarrayCoveringSet1(List<String> paragraph, Set<String> keywords ) {
		
		// slower version because we need to keep subarrays in memory
		
		Map<String, Integer> keywordMap = new HashMap<String, Integer>();
		for(String key: keywords) {
			keywordMap.put(key, keywordMap.containsKey(key) ? keywordMap.get(key)+1 : 1);
		}
		
		SubArray result = new SubArray(-1, -1);
		int remain = keywords.size();
		
		for(int left =0 , right =0; right < paragraph.size() ; right++) {
			Integer keywordCount = keywordMap.get(paragraph.get(right));
			if(keywordCount != null) {
				keywordMap.put(paragraph.get(right), keywordCount -1);
				if(keywordCount >= 0) {
					remain--;
				}
			}
		//keep advancing left until it raecher end or keywordsMap does not
			while(remain == 0) {
				if((result.start == -1 && result.end == -1)|| (right-left < result.end -result.start)) {
				result.start = left;
				result.end = right;
			}
				keywordCount = keywordMap.get(paragraph.get(left));
			
				if(keywordCount != null) {
					keywordMap.put(paragraph.get(left), keywordCount +1);
					if(keywordCount > 0) {
						remain++;
					}
				}
				left++;
		
	
		}
	}
		return result;
	}
}
