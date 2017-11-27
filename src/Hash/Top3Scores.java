package Hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class Top3Scores {
	
	public static String findStudentwithTop3Scores(Iterator<Object> nameScoreData) {
		
		Map<String, PriorityQueue<Integer>> studentScoresMap = new HashMap<>();
		while(nameScoreData.hasNext()) {
			String name = (String) nameScoreData.next();
			Integer score = (Integer) nameScoreData.next();
			
			PriorityQueue<Integer> scoresQueue = studentScoresMap.get(name);
			if(scoresQueue == null) {
				scoresQueue = new PriorityQueue<>();
				studentScoresMap.put(name, scoresQueue);
			}
			
			scoresQueue.add(score);
			if(scoresQueue.size()>3) {
				scoresQueue.poll();
			}
		}
		
		String topStudent = "no such student";
		int maxSum =0;
		for(Map.Entry<String, PriorityQueue<Integer>> entry  : studentScoresMap.entrySet()) {
			if(entry.getValue().size()==3) {
				int currSum = getStudentSum(entry.getValue());
				if(currSum > maxSum) {
					maxSum = currSum;
					topStudent = entry.getKey();
				}
			}
		}
		
		return topStudent;
		
	}

	private static int getStudentSum(PriorityQueue<Integer> value) {
		Iterator<Integer> iter = value.iterator();
		int result = 0;
		while(iter.hasNext()) {
			result += iter.next();
		}
		return result;
	}

}
