package kadanesAlgorithm;

public class MaximumAbsoluteSumOfAnySubarray {

	public static void main(String[] args) {

		int[] nums = { 1, -3, 2, 3, -4 };

		int result = maxAbsoluteSum(nums);

		System.out.println("Maximum Absolute Sum: " + result);
	}

	public static int maxAbsoluteSum(int[] nums) {

		int maxEnding = nums[0];
		int minEnding = nums[0];
		int maxSoFar = nums[0];
		int minSoFar = nums[0];

		for (int i = 1; i < nums.length; i++) {
			maxEnding = Math.max(maxEnding + nums[i], nums[i]);
			minEnding = Math.min(minEnding + nums[i], nums[i]);
			maxSoFar = Math.max(maxSoFar, maxEnding);
			minSoFar = Math.min(minSoFar, minEnding);
		}

		return Math.max(Math.abs(minSoFar), Math.abs(maxSoFar));
	}

}
