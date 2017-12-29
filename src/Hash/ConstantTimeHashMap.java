package Hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class ConstantTimeHashMap {

	/*
	 * Java program to design a data structure that support folloiwng operations in
	 * Θ(1) time. a) Insert b) Delete c) Search d) getRandom
	 */

	ArrayList<Integer> arr; // A resizable array
	HashMap<Integer, Integer> hash;

	// Constructor (creates arr[] and hash)
	public ConstantTimeHashMap() {
		arr = new ArrayList<Integer>();
		hash = new HashMap<Integer, Integer>();
	}

	
	void add(int x) {
		if (hash.get(x) != null)
			return;

		int s = arr.size();
		arr.add(x);

		hash.put(x, s);
	}

	void remove(int x) {
		// Check if element is present
		Integer index = hash.get(x);
		if (index == null)
			return;

		// If present, then remove element from hash
		hash.remove(x);

		// Swap element with last element so that remove from
		// arr[] can be done in O(1) time
		int size = arr.size();
		Integer last = arr.get(size - 1);
		Collections.swap(arr, index, size - 1);

		// Remove last element (This is O(1))
		arr.remove(size - 1);

		// Update hash table for new index of last element
		hash.put(last, index);
	}

	// Returns a random element from MyDS
	int getRandom() {
		// Find a random index from 0 to size - 1
		Random rand = new Random(); // Choose a different seed
		int index = rand.nextInt(arr.size());

		// Return element at randomly picked index
		return arr.get(index);
	}
}
