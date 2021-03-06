package Hash;

import java.util.HashSet;

/*
 * Given an array of distinct elements and a number x, find if there is a pair with product equal to x.

Examples :

Input : arr[] = {10, 20, 9, 40};
        int x = 400;
Output : Yes

Input : arr[] = {10, 20, 9, 40};
        int x = 190;
Output : No

Input : arr[] = {-10, 20, 9, -40};
        int x = 400;
Output : Yes

Input : arr[] = {-10, 20, 9, 40};
        int x = -400;
Output : Yes

Input : arr[] = {0, 20, 9, 40};
        int x = 0;
Output : Yes
 */

public class FindProductInAnArray {

	// Returns true if there is a pair in arr[0..n-1]
	// with product equal to x.
	static boolean isProduct(int arr[], int n, int x) {
		// Create an empty set and insert first
		// element into it
		HashSet<Integer> hset = new HashSet<>();

		if (n < 2)
			return false;

		// Traverse remaining elements
		for (int i = 0; i < n; i++) {
			// 0 case must be handles explicitly as x % 0 is undefined
			if (arr[i] == 0) {
				if (x == 0)
					return true;
				else
					continue;
			}

			// x/arr[i] exists in hash, then we found a pair
			if (x % arr[i] == 0) {
				if (hset.contains(x / arr[i])) return true;

				hset.add(arr[i]);
			}
		}
		return false;
	}

}
