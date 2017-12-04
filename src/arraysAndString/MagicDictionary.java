package arraysAndString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MagicDictionary {

    Map<String, List<int[]>> map = new HashMap<>();
    /** Initialize your data structure here. */
    public MagicDictionary() {
    }
    
    /*
     * 
     * For each word in dict, for each char, remove the char and put the rest of the word as key, 
     * a pair of index of the removed char and the char as part of value list into a map. e.g.
"hello" -> {"ello":[[0, 'h']], "hllo":[[1, 'e']], "helo":[[2, 'l'],[3, 'l']], "hell":[[4, 'o']]}

During search, generate the keys as in step 1. When we see there's pair of same index but different char in the value array, 
we know the answer is true. e.g.
"healo" when remove a, key is "helo" and there is a pair [2, 'l'] which has same index but different char. Then the answer is true;
     */
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String s : dict) {
            for (int i = 0; i < s.length(); i++) {
                String key = s.substring(0, i) + s.substring(i + 1);
                int[] pair = new int[] {i, s.charAt(i)};
                
                List<int[]> val = map.getOrDefault(key, new ArrayList<int[]>());
                val.add(pair);
                
                map.put(key, val);
            }
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (int i = 0; i < word.length(); i++) {
            String key = word.substring(0, i) + word.substring(i + 1);
            if (map.containsKey(key)) {
                for (int[] pair : map.get(key)) {
                    if (pair[0] == i && pair[1] != word.charAt(i)) return true;
                }
            }
        }
        return false;
    }
}