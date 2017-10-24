package Hash;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

class RandomizedSet {

	HashSet<Integer> set;
	Random random = new Random();

	/** Initialize your data structure here. */
	public RandomizedSet() {
		set = new HashSet<>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if (!set.contains(val)) {
			set.add(val);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		if (set.contains(val)) {
			set.remove(val);
			return true;
		} else {
			return false;
		}
	}

	/** Get a random element from the set. */
	public int getRandom() {
		int size = set.size();
		int n = random.nextInt(size);
		Iterator<Integer> iter = set.iterator();
		for (int i = 0; i < n; i++) {
			iter.next();
		}
		return iter.next();
	}
}