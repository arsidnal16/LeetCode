package Hash;

import java.util.HashMap;

public class ClosestPairInanArray {
	
	
 	public int closetPair(String[] str) {
 		if(str == null) {
 			return -1;
 		} else if(str.length <= 1) {
 			return 0;
 		}

 		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
 		int distance = Integer.MAX_VALUE;
 		for(int i = 0; i < str.length; i++) {
 			if(hashMap.containsKey(str[i])) {
 				if((i - hashMap.get(str[i])) < distance) {
 					distance = i;
 				}
 			} else {
 				hashMap.put(str[i], i);
 			}
 		}

 		return distance;
 	}

}
