package arraysAndString;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {
	
	public static List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<String>();
        if (digits.length()==0){
	        return result;
        }
        
        String[] strArray = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(result.peek().length()==i){
                String t = result.remove();
                for(char s : strArray[x].toCharArray())
                  result.add(t+s);
            }
        }
    return result;
    }
	
	public static void main(String args[]) {
		System.out.println(letterCombinations("23"));
	}

}
