package arraysAndString;

public class LongestnonOverlappingPalindromesubsequenceProduct {
	

		static int[][] longestPalindromicSubsequence(String seq)
		{
		       int n = seq.length();
		       int i, j, cl;
		       int L[][] = new int[n][n];  
		      
		       
		       for (i = 0; i < n; i++)
		           L[i][i] = 1;           
		        
		        for (cl=2; cl<=n; cl++)
		        {
		            for (i=0; i<n-cl+1; i++)
		            {
		                j = i+cl-1;
		                if (seq.charAt(i) == seq.charAt(j) && cl == 2)
		                   L[i][j] = 2;
		                else if (seq.charAt(i) == seq.charAt(j))
		                   L[i][j] = L[i+1][j-1] + 2;
		                else
		                   L[i][j] = Math.max(L[i][j-1], L[i+1][j]);
		            }
		        }
		        //System.out.println(L[0][n-1]);
		        return L;
		}
		    static int funPal(String s) 
		    {
		    int prodMax = -1;
		    int resArr[][] = longestPalindromicSubsequence(s);
		    for(int i=0; i<s.length()-1;i++)
		    {
		        int tempProd = resArr[0][i] * resArr[i+1][s.length()-1];
		        if(prodMax <= tempProd)
		            prodMax = tempProd;
		    }
		    return prodMax;
		}
		    
		public static void main(String[] args) {
		         
		        System.out.println(funPal("axbawbaseksqke"));
		        
		    }

		

}
