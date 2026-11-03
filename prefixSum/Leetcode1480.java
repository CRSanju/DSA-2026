package prefixSum;

import java.util.Arrays;

public class Leetcode1480 {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4 };

		int[] result = runningSum(nums);

		System.out.println(Arrays.toString(result));
	}

	public static int[] runningSum(int[] nums) {

		int sum = nums[0];
		int newArr[] = new int[nums.length];
		newArr[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum = sum + nums[i];
			newArr[i] = sum;
		}

		return newArr;
	}
}
