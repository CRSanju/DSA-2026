package TwoPointer;

import java.util.Arrays;
import java.util.Scanner;

public class TripletsWithSmallerSum {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the size of the array: ");
		int n = sc.nextInt();

		int[] arr = new int[n];

		System.out.println("Enter the elements:");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.print("Enter the target sum: ");
		int target = sc.nextInt();

		int result = countTriplets(target, arr);

		System.out.println("Number of triplets: " + result);

		sc.close();
	}

	public static int countTriplets(int sum, int[] arr) {
		Arrays.sort(arr);
		int count = 0;

		for (int i = 0; i < arr.length - 2; i++) {
			int left = i + 1;
			int right = arr.length - 1;
			while (left < right) {
				int total = arr[i] + arr[left] + arr[right];
				if (total >= sum) {
					right--;
				} else {
					count = count + (right - left);
					left++;
				}
			}
		}

		return count;
	}
}
