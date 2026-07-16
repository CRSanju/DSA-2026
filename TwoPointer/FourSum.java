package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FourSum {

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

		List<List<Integer>> result = fourSum(nums, target);

		System.out.println(result);

		sc.close();
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int left = j + 1;
				int right = nums.length - 1;

				while (left < right) {
					long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
					if (sum > target) {
						right--;
					} else if (sum < target) {
						left++;
					} else {
						res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						left++;
						right--;

						while (left < right && nums[left] == nums[left - 1]) {
							left++;
						}

						while (right > left && nums[right] == nums[right + 1]) {
							right--;
						}
					}
				}
			}
		}
		return res;
	}
}