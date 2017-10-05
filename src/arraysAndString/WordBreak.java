package arraysAndString;
import java.util.List;

public class WordBreak {
	
	/*
	 * 
	 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
	 *  determine if s can be segmented into a space-separated sequence of one or more dictionary words. 
	 *  You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
	 * 
	 * 
	 */
	
	public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        
        f[0] = true;
        
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }

}
