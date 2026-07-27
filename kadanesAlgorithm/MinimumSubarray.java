package kadanesAlgorithm;

public class MinimumSubarray {

	public static void main(String[] args) {

		int[] nums = { 3, -4, 2, -3, -1, 7, -5 };

		int result = smallestSumSubarray(nums);

		System.out.println("Minimum Sum: " + result);
	}

	public static int smallestSumSubarray(int[] nums) {

		int bestEnding = nums[0];
		int ans = nums[0];
		for (int i = 1; i < nums.length; i++) {
			bestEnding = Math.min(nums[i], bestEnding + nums[i]);
			ans = Math.min(ans, bestEnding);
		}

		return ans;
	}

}
