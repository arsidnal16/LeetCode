package arraysAndString;

import java.util.Arrays;

/*
 * computes the number of ways to make the amount of money with coins of the available denominations.

Example: for amount=44 (44¢) and denominations=[1,2,3][1,2,3] (11¢, 22¢ and 33¢), 
your program would output 44—the number of ways to make 44¢ with those denominations:

1¢, 1¢, 1¢, 1¢
1¢, 1¢, 2¢
1¢, 3¢
2¢, 2¢
 * 
 */
public class CoinChange {
	
	/*
	 * We use a bottom-up ↴ algorithm to build up a table waysOfDoingNCents
	 *  such that waysOfDoingNCents[k] is how many ways we can get to k cents using our denominations.
	 *  We start with the base case that there's one way to create the amount zero, and progressively add each of our denominations.

The number of new ways we can make a higherAmount 
when we account for a new coin is simply waysOfDoingNCents[higherAmount - coin],
 where we know that value already includes combinations 
 involving coin (because we went bottom-up, we know smaller values have already been calculated).
	 * 
	 */
	
	  public static int changePossibilitiesBottomUp(int amount, int[] denominations) {
		    int[] waysOfDoingNCents = new int[amount + 1];  // array of zeros from 0..amount
		    waysOfDoingNCents[0] = 1;

		    for (int coin : denominations) {
		    	
		        for (int higherAmount = coin; higherAmount <= amount; higherAmount++) {
		            int higherAmountRemainder = higherAmount - coin;
		            waysOfDoingNCents[higherAmount] += waysOfDoingNCents[higherAmountRemainder];
		        }
		    }

		    return waysOfDoingNCents[amount];
		}
	  
	  
	  static long countWays(int S[], int m, int n)
	    {
	        //Time complexity of this function: O(mn)
	        //Space Complexity of this function: O(n)
	 
	        // table[i] will be storing the number of solutions
	        // for value i. We need n+1 rows as the table is
	        // constructed in bottom up manner using the base
	        // case (n = 0)
	        long[] table = new long[n+1];
	 
	        // Initialize all table values as 0
	        Arrays.fill(table, 0);   //O(n)
	 
	        // Base case (If given value is 0)
	        table[0] = 1;
	 
	        // Pick all coins one by one and update the table[]
	        // values after the index greater than or equal to
	        // the value of the picked coin
	        for (int i=0; i<m; i++)
	            for (int j=S[i]; j<=n; j++)
	                table[j] += table[j-S[i]];
	 
	        return table[n];
	    }
	 
	    // Driver Function to test above function
	    public static void main(String args[])
	    {
	        int arr[] = {1, 2, 3};
	        int m = arr.length;
	        int n = 100;
	        System.out.println(countWays(arr, m, n));
	    }

}
