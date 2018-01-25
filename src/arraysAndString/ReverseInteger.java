package arraysAndString;

public class ReverseInteger {

	public static int reverse(int x) {
		 
		int result = 0;

	    while (x != 0)
	    {
	        int tail = x % 10;
	        result = result * 10 + tail;
	        x = x / 10;
	        
	        System.out.println("x is "+ x);
	    }
	    
	    System.out.println(result);
	    return result;
    }
	
	
	public static void main(String args[]) {
		int x = -321;
		int y = 0;
		
		reverse(x);
		reverse(y);
	}
	
}
