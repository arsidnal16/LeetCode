package simpleArray;

public class CanPlaceFlowers {
	
	/*
	 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty),
	 *  and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

		Example 1:
			Input: flowerbed = [1,0,0,0,1], n = 1
			Output: True
		Example 2:	
			Input: flowerbed = [1,0,0,0,1], n = 2
			Output: False
	 */
	
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i = 0; i < flowerbed.length && count < n; i++) {
            if(flowerbed[i] == 0) {
	     //get next and prev flower bed slot values. If i lies at the ends the next and prev are considered as 0. 
               int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1]; 
               int prev = (i == 0) ? 0 : flowerbed[i - 1];
               if(next == 0 && prev == 0) {
                   flowerbed[i] = 1;
                   count++;
               }
            }
        }
        
        return count == n;
    }

}
