package arraysAndString;
public class StringToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int atoi(String str) {
		if (str == null || str.length() < 1)
			return 0;
	 
		// trim white spaces
		str = str.trim();
	 
		char flag = '+';
	 
		// check negative or positive
		int i = 0;
		if (str.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}
		// use double to store result
		long result = 0;
	 
		// calculate value
		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
	 
		if (flag == '-')
			result = -result;
	 
		// handle max and min
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
	 
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
	 
		return (int) result;
	}
	
	
	
	
	
	
	
	public static String intToSTring(int x) {
		boolean isNegative = false;
		if(x < 0) {
			isNegative = true;
		}
		
		StringBuilder sb = new StringBuilder();
		do {
			sb.append((char)('0'+ Math.abs(x%10)));
			x/=10;
		} while(x!=0);
		
		if(isNegative) {
			sb.append('-');
		}
		
		sb.reverse();
		return sb.toString();
		
	}

}