package TwoPointer;

import java.util.Arrays;
import java.util.Scanner;

public class SortColors {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the size of the array: ");
		int n = sc.nextInt();

		int[] nums = new int[n];

		System.out.println("Enter the elements (0, 1, 2):");
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}

		sortColors(nums);

		System.out.println("Sorted Array:");
		System.out.println(Arrays.toString(nums));

		sc.close();
	}

	public static void sortColors(int[] nums) {

		int low = 0;
		int mid = 0;
		int high = nums.length - 1;

		while (mid <= high) {
			if (nums[mid] == 0) {
				int temp = nums[mid];
				nums[mid] = nums[low];
				nums[low] = temp;

				mid++;
				low++;
			} else if (nums[mid] == 1) {
				mid++;
			} else {
				int tem = nums[mid];
				nums[mid] = nums[high];
				nums[high] = tem;

				high--;
			}
		}

	}

}
