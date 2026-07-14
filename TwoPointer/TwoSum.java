package TwoPointer;

import java.util.Arrays;
import java.util.Scanner;

public class TwoSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the length of the array");
		int a = sc.nextInt();
		int arr[] = new int[a];

		System.out.println("Enter the elements of the array");
		for (int i = 0; i <= arr.length - 1; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println("Enter the target you are looking for");
		int target = sc.nextInt();

		int result[] = twoSum(arr, target);
		System.out.println(Arrays.toString(result));

		sc.close();
	}

	public static int[] twoSum(int arr[], int target) {
		int left = 0;
		int right = arr.length - 1;
		for (int i = 0; i <= arr.length - 1; i++) {
			int sum = arr[left] + arr[right];
			if (sum == target) {
				return new int[] { left + 1, right + 1 };
			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}
		return new int[] { -1, -1 };
	}

}
