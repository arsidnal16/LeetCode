package Hash;

import java.util.HashSet;

public class CheckDuplicatesWithinK {
	static boolean checkDuplicatesWithinK(int arr[], int k) {
		// Creates an empty hashset
		HashSet<Integer> set = new HashSet<>();

		// Traverse the input array
		for (int i = 0; i < arr.length; i++) {
			// If already present n hash, then we found
			// a duplicate within k distance
			if (set.contains(arr[i]))
				return true;

			// Add this item to hashset
			set.add(arr[i]);

			// Remove the k+1 distant item
			if (i >= k)
				set.remove(arr[i - k]);
		}
		return false;
	}
}
