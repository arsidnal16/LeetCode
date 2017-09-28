package Medium;
public class celebrity 
{
    // Person with 2 is celebrity
    static int MATRIX[][] = { { 0, 0, 1, 0 },
                              { 0, 0, 1, 0 }, 
                              { 0, 0, 0, 0 },
                              { 0, 0, 1, 0 } };
 
    // Returns true if a knows b, false otherwise
    static boolean knows(int a, int b) 
    {
        boolean res = (MATRIX[a][b] == 1) ? true : false;
        return res;
    }
 
    // Returns -1 if celebrity is not present.
    // If present, returns id (value from 0 to n-1).
    static int findCelebrity(int n) 
    {
        // Initialize two pointers as two corners
        int a = 0;
        int b = n - 1;
         
        // Keep moving while the two pointers
        // don't become same.
        while (a < b) 
        {
            if (knows(a, b))
                a++;
            else
                b--;
        }
 
        // Check if a is actually a celebrity or not
        for (int i = 0; i < n; i++) 
        {
            // If any person doesn't know 'a' or 'a'
            // doesn't know any person, return -1
            if (i != a && (knows(a, i) || !knows(i, a)))
                return -1;
        }
        return a;
    }
 
    // Driver program to test above methods
    public static void main(String[] args) 
    {
        int n = 4;
        int result = findCelebrity(n);
        if (result == -1) 
        {
            System.out.println("No Celebrity");
        } 
        else
            System.out.println("Celebrity ID " + result);
    }
}
 