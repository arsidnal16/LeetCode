package arraysAndString;

public class Fibonacci {
	
	/*
	 * 
	 * Also, as F(n) = F(n-1) + F(n-2), we need only the last 2 values of the series to find the next value. 
	 * Hence, we do not need to store all subproblem solutions but only the previous 2 
	 * i.e. F(i-1) and F(i-2). Once we have F(i), for calculating F(i+1) we just need F(i) and F(i-1), 
	 * and therefore we can discard F(i-2) as it is not needed further.
So starting with F(0) = 0, F(1) = 1, we can use bottom up approach to calculate F(n)
1. Boundary Condition: If n = 0 or n = 1, return n
2. Take a = 0, b = 1
3. Loop n-2 times, and calculate
   c = a+b
   a = b
   b = c
4. Return c
	 * 
	 * 
	 */
	
	
	public int getFibonacci(int n) {
		if(n<0) {
			throw new IllegalArgumentException("n cannot be negative");
		}
		
		if(n == 0 || n== 1) {
			return n;
		}
		
		int a =0;
		int b = 1;
		int c = a+b;
		for(int i=2 ; i<n ; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		
		return c;
	}
}
