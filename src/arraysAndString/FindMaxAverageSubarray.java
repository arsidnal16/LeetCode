package arraysAndString;

public class FindMaxAverageSubarray {

	/*
	 * 
	 * Given an array consisting of n integers, find the contiguous subarray of
	 * given length k that has the maximum average value. And you need to output the
	 * maximum average value.
	 * 
	 * Example 1: Input: [1,12,-5,-6,50,3], k = 4 Output: 12.75 Explanation: Maximum
	 * average is (12-5-6+50)/4 = 51/4 = 12.75
	 */

	public double findMaxAverage(int[] nums, int k) {
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += nums[i];
		}

		int maxSum = sum;
		for (int i = 0, j = k; j < nums.length; i++, j++) {
			sum = sum - nums[i] + nums[j];
			maxSum = Math.max(sum, maxSum);
		}

		return ((double) maxSum) / ((double) k);

	}

}
