package SlidingWindow;

import java.util.Scanner;

public class MaxSumSubarraySizeK {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the length of the array");
		int a = sc.nextInt();
		int arr[] = new int[a];

		System.out.println("Enter the elements");
		for (int i = 0; i <= arr.length - 1; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println("Enter the subarray size");
		int k = sc.nextInt();

		int result = maxSubarray(arr, k);
		System.out.println(result);

		sc.close();
	}

	public static int maxSubarray(int[] arr, int k) {
		int sum = 0;
		for (int i = 0; i <= k - 1; i++) {
			sum += arr[i];
		}

		int res = sum;
		for (int i = k; i <= arr.length - 1; i++) {
			sum += arr[i] - arr[i - k];
			res = Math.max(res, sum);
		}

		return res;
	}
}
