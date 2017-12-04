package arraysAndString;

import java.util.Arrays;

public class TimePlanner {

	
	/*
	 * 
	 * Time Planner

Implement a function meetingPlanner that given the availability, slotsA and slotsB, of two people and a meeting duration dur, 
returns the earliest time slot that works for both of them and is of duration dur. If there is no common time slot that satisfies 
the duration requirement, return null.

Time is given in a Unix format called Epoch, which is a nonnegative integer holding the number of seconds that have elapsed since 00:00:00 UTC, Thursday, 1 January 1970.

Each person’s availability is represented by an array of pairs. Each pair is an epoch array of size two. The first epoch in a pair represents the start time of a slot. The second epoch is the end time of that slot. The input variable dur is a positive integer that represents the duration of a meeting in seconds. The output is also a pair represented by an epoch array of size two.

In your implementation assume that the time slots in a person’s availability are disjointed, i.e, time slots in a person’s availability don’t overlap. Further assume that the slots are sorted by slots’ start time.

Implement an efficient solution and analyze its time and space complexities.

Examples:

input:  slotsA = [[10, 50], [60, 120], [140, 210]]
        slotsB = [[0, 15], [60, 70]]
        dur = 8
output: [60, 68]

input:  slotsA = [[10, 50], [60, 120], [140, 210]]
        slotsB = [[0, 15], [60, 70]]
        dur = 12
output: null # since there is no common slot whose duration is 12
	 * 
	 * 
	 */
	static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
		int ia = 0;
		int ib = 0;

		while (ia < slotsA.length && ib < slotsB.length) {
			int start = Math.max(slotsA[ia][0], slotsB[ib][0]);
			int end = Math.min(slotsA[ia][1], slotsB[ib][1]);

			if (start + dur <= end)
				return new int[] { start, start + dur };

			if (slotsA[ia][1] < slotsB[ib][1])
				ia++;
			else
				ib++;
		}
		return new int[] {};

	}
	
	public static void main(String[] args) {
		int[] [] a = {{7,12}};
		int [][] b = {{2,11}}; 
		System.out.println(Arrays.toString(meetingPlanner(a, b, 5)));
		
		int[] [] c = {{6,12}};
		int [][] d = {{2,11}}; 
		System.out.println(Arrays.toString(meetingPlanner(c, d, 5)));
		
		int[] [] e = {{1,10}};
		int [][] f = {{2,3}, {5,7}}; 
		System.out.println(Arrays.toString(meetingPlanner(e, f, 2)));
		
		
		int[] [] g = {{10,50}, {60,120}, {140,210}};
		int [][] h = {{0,15},{60,70}}; 
		System.out.println(Arrays.toString(meetingPlanner(g, h, 8)));
		
		int[] [] i = {{10,50}, {60,120}, {140,210}};
		int [][] j = {{0,15},{60,72}}; 
		System.out.println(Arrays.toString(meetingPlanner(i, j, 12)));
		
	  }

	
	
}
