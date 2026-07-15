package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeSum {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the size of the array: ");
		int n = sc.nextInt();

		int[] nums = new int[n];

		System.out.println("Enter the elements:");
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}

		List<List<Integer>> result = threeSum(nums);

		System.out.println(result);

		sc.close();
	}

	public static List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum > 0) {
					right--;
				} else if (sum < 0) {
					left++;
				} else {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
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

		return res;

	}
}
