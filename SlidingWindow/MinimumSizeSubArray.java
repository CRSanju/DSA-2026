package SlidingWindow;

import java.util.Scanner;

public class MinimumSizeSubArray {

	public static int solve(int target, int[] nums) {

		int low = 0;
		int high = 0;
		int sum = 0;
		int diff = Integer.MAX_VALUE;

		while (high <= nums.length - 1) {
			sum += nums[high];

			while (sum >= target) {
				int windowSize = high - low + 1;
				diff = Math.min(diff, windowSize);
				sum -= nums[low];
				low++;
			}
			high++;
		}

		if (diff == Integer.MAX_VALUE) {
			return 0;
		}

		return diff;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the size of the array: ");
		int n = sc.nextInt();

		int[] nums = new int[n];

		System.out.println("Enter the elements:");
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}

		System.out.print("Enter the target: ");
		int target = sc.nextInt();

		int result = solve(target, nums);

		System.out.println("Minimum Length = " + result);

		sc.close();
	}

}
