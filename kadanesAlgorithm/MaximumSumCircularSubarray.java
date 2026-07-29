package kadanesAlgorithm;

public class MaximumSumCircularSubarray {

	public static int maxSubarraySumCircular(int[] nums) {

		int maxBestEnding = nums[0];
		int maxCurr = nums[0];

		int minBestEnding = nums[0];
		int minCurr = nums[0];

		int totalSum = nums[0];

		for (int i = 1; i < nums.length; i++) {
			maxBestEnding = Math.max(maxBestEnding + nums[i], nums[i]);
			maxCurr = Math.max(maxCurr, maxBestEnding);

			minBestEnding = Math.min(minBestEnding + nums[i], nums[i]);
			minCurr = Math.min(minCurr, minBestEnding);

			totalSum += nums[i];
		}

		if (maxCurr > 0) {
			return Math.max(maxCurr, totalSum - minCurr);
		}

		return maxCurr;
	}

	public static void main(String[] args) {

		int[] nums = { 5, -3, 5 };

		int result = maxSubarraySumCircular(nums);

		System.out.println(result);
	}

}
