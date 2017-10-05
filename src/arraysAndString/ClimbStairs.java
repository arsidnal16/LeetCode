package arraysAndString;

public class ClimbStairs {

	public int climbStairs(int n) {
	  // base cases
		if(n == 0 || n == 1 || n == 2){return n;}
	    int[] mem = new int[n];
	    mem[0] = 1;
	    mem[1] = 2;
	    for(int i = 2; i < n; i++){
	        mem[i] = mem[i-1] + mem[i-2];
	    }
	    return mem[n-1];
	}
	
	public int climbStairs2(int n) {
	if(n==0||n==1) return  1;
    int stepOne=1,stepTwo=1;
    int result=0;
    for(int i=2;i<=n;i++){
        result=stepOne+stepTwo;
        stepTwo=stepOne;
        stepOne=result;
    }
    return result;
	}
}
