package stackQueue;
import java.util.Stack;

public class ValidParanthesis {
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		
		String st = s.replaceAll("[a-zA-Z0-9 ]", "");
		for (char c : st.toCharArray()) {
			
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
	
	public static void main(String args[]) {
		boolean res = isValid("[{()}]");
		System.out.println(res);
	}

}
