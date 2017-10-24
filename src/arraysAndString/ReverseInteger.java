package arraysAndString;

public class ReverseInteger {

	public static int reverse(int x) {
		 
		int result = 0;

	    while (x != 0)
	    {
	        int tail = x % 10;
	        
	        System.out.println("tail is "+tail);
	        result = result * 10 + tail;
	        
	        System.out.println("new Result is "+result);
	       
	        x = x / 10;
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
