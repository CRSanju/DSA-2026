package kadanesAlgorithm;

public class MaximumSubarraySumWithOneDeletion {

	public static void main(String[] args) {

		int[] nums = { 1, -2, 0, 3 };

		int result = maximumSum(nums);

		System.out.println("Maximum Sum: " + result);
	}

	public static int maximumSum(int[] nums) {

		int maxNodelete = nums[0];
		int maxOnedelete = nums[0];
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int prevNoDelete = maxNodelete;
			maxNodelete = Math.max(maxNodelete + nums[i], nums[i]);
			maxOnedelete = Math.max(maxOnedelete + nums[i], prevNoDelete);
			res = Math.max(res, Math.max(maxOnedelete, maxNodelete));
		}

		return res;
	}
}
