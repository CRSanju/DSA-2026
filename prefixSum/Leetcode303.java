package prefixSum;

public class Leetcode303 {

	int prefix[];

	public Leetcode303(int[] nums) {

		prefix = new int[nums.length];
		prefix[0] = nums[0];
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum = sum + nums[i];
			prefix[i] = sum;
		}

	}

	public int sumRange(int left, int right) {

		if (left == 0) {
			return prefix[right];
		}

		return prefix[right] - prefix[left - 1];
	}

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4, 5 };

		Leetcode303 obj = new Leetcode303(nums);

		System.out.println(obj.sumRange(1, 3)); // Expected: 9
		System.out.println(obj.sumRange(0, 3)); // Expected: 10
	}
}
