package arraysAndString;

public class ValidPalindrome2 {
	
	/* Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
	*
	*Example 1:
		Input: "aba"
		Output: True
	Example 2:
		Input: "abca"
		Output: True
        Explanation: You could delete the character 'c'.
	*
	*
	*/
	public boolean validPalindrome(String s) {
	      char[] sc = s.toCharArray();
	      int i = 0, j = s.length() - 1;
	      while(i < j){
	        if(sc[i] != sc[j]){
	          return helper(sc, i + 1, j) || helper(sc, i, j - 1);
	        }
	        i++;
	        j--;
	      }
	        return true;
	    }

	    boolean helper(char[] sc, int i, int j){
	       while(i < j){
	         if(sc[i] != sc[j]) return false;
	         i++; j--;
	       }
	      return true;
	    }

}
