package arraysAndString;

import java.util.ArrayList;

public class PascalTriangle {

	public static void main(String args[]) {
		int k = 7;
		System.out.println(generatePascalTriangle(k));
	}

	private static ArrayList<ArrayList<Integer>> generatePascalTriangle(int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (k <= 0) {
			return result;
		}
		ArrayList<Integer> pre = new ArrayList<>();
		pre.add(1);
		result.add(pre);

		for (int i = 2; i <= k; i++) {
			ArrayList<Integer> curr = new ArrayList<>();

			curr.add(1); // first
			for (int j = 0; j < pre.size() - 1; j++) {
				curr.add(pre.get(j) + pre.get(j + 1));
			}
			curr.add(1);
			// System.out.println();

			result.add(curr);

			pre = curr;
		}
		return result;
	}

}