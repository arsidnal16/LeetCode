package arraysAndString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsWithoutDups {
	
	List<String> printPerms(String str){
		List<String> list = new ArrayList<String>();
		Map<Character, Integer> map = new HashMap<>();
		for(char c: str.toCharArray()){
			if(!map.containsKey(c)) {
				map.put(c, 1);
			}
			else {
				map.put(c, map.get(c)+1);
			}
		}
		
		printPerms(map, "", str.length(),list );
		return list;
	}

	private void printPerms(Map<Character, Integer> map, String prefix, int length, List<String> list) {
		if(length == 0) {
			list.add(prefix);
			return;
		}
		
		for(char c : map.keySet()) {
			int count = map.get(c);
			
			if(count > 1) {
				map.put(c, count -1);
				printPerms(map, prefix+c, length -1, list);
				map.put(c,  count);
			}
		}
		
	}

}
