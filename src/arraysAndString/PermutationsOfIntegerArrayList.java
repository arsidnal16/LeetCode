package arraysAndString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationsOfIntegerArrayList {
	
	public static void main(String args[]) {
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(3);
		list.add(5);
		
		List<List<Integer>> result = permutations(list);
		System.out.println(result);
		
	}
	
	public static List<List<Integer>> permutations(List<Integer> A){
		List<List<Integer>> result = new ArrayList<>();
		generatePermutations(0, A, result);
		return result;
	}

	private static void generatePermutations(int i, List<Integer> a, List<List<Integer>> result) {
		if(i == a.size() -1) {
			result.add(new ArrayList<>(a));
			return;
		}
		
		System.out.println("result here is " + result);
		
		for(int j = 0 ; j< a.size(); j++) {
			Collections.swap(a, i, j);
			generatePermutations(i+1, a, result);
			Collections.swap(a, i, j);
		}
		
		
		
	}

}
