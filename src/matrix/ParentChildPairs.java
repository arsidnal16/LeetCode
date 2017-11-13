package matrix;

import java.io.*;
import java.util.*;

// Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

// For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:

// 1   2   4
//  \ /   / \
//   3   5   8
//    \ / \   \
//     6   7   9

// Write a function that takes this data as input and returns two collections: one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.

public class ParentChildPairs {
	public static void main(String[] args) {
		int[][] parentChildPairs = new int[][] { { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5 }, { 4, 8 },
				{ 8, 9 } };

		// 1 2 3 5 5 4 4 8
		// 3 3 6 6 7 5 8 9

		// {1,3} - {parent, child}

		// Sample output (pseudocode):
		// [
		// [1, 2, 4], //Individuals with zero parents
		// [5, 7, 8, 9] //Individuals with one parent
		// ]
		List<List<Integer>> zeroOneParent = getZeroOOneParent(parentChildPairs);

		System.out.print(zeroOneParent);

	}

	public static List<List<Integer>> getZeroOOneParent(int[][] arr) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		List<Integer> oneList = getOneParent(arr);
		List<Integer> zeroList = getZeroParent(arr);

		result.add(oneList);

		result.add(zeroList);

		return result;

	}

	public static List<Integer> getOneParent(int[][] arr) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {

			int key = arr[i][1];

			// System.out.println(key);

			if (map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}

			// System.out.println(map.keySet() + " , " + map.values());

		}

		// System.out.println(map.keySet() + " , " + map.values());

		List<Integer> list = new ArrayList<Integer>();

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			if (entry.getValue() == 1) {
				list.add(entry.getKey());
			}

		}

		return list;

	}

	public static List<Integer> getZeroParent(int[][] arr) {

		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {

			set.add(arr[i][1]);

		}

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {

			if (set.contains(arr[i][0])) {
				continue;
			}
			else {
				list.add(arr[i][0]);
				set.add(arr[i][0]);
			}

		}

		return list;

	}

}