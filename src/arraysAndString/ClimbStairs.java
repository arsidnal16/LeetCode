package arraysAndString;

public class ClimbStairs {

	/*
	 * 
	 * One can reach i ​th ​​ step in one of the two ways:
	 * 
	 * Taking a single step from (i−1) ​th ​​ step.
	 * 
	 * Taking a step of 2 from (i−2) ​th ​​ step.
	 * 
	 * So, the total number of ways to reach i ​th ​​ is equal to sum of ways
	 * of reaching (i−1) ​th ​​ step and ways of reaching (i−2) ​th ​​ step.
	 * 
	 * Let dp[i] denotes the number of ways to reach on i ​th ​​ step.
	 * 
	 * dp[i]=dp[i-1]+dp[i-2]
	 */

	public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
