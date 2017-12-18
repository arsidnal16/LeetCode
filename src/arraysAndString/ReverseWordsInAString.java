package arraysAndString;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsInAString {

	public String reverseWords(String s) {
		String[] words = s.trim().split(" +");
		Collections.reverse(Arrays.asList(words));
		return String.join(" ", words);
	}

	public String reverseWords2(String s) {
        String[] arr = s.trim().split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        for(int i=arr.length-1; i>0;i--){
            sb.append(arr[i] + " ");
        }
        
        return sb.toString() + arr[0];
    }
}
