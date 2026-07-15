package TwoPointer;

import java.util.Arrays;
import java.util.Scanner;

public class ClosestSum16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of the array");
		int a = sc.nextInt();
		int arr[] = new int[a];

		System.out.println("Enter the elements");
		for (int i = 0; i <= arr.length - 1; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println("Enter the target value");
		int k = sc.nextInt();

		int result = closestSum(arr, k);
		System.out.println(result);

		sc.close();
	}

	public static int closestSum(int arr[], int target) {
		Arrays.sort(arr);
		int minDifferene = Integer.MAX_VALUE;
		int closest = 0;

		for (int i = 0; i < arr.length - 2; i++) {
			int left = i + 1;
			int right = arr.length - 1;
			while (left < right) {
				int sum = arr[i] + arr[left] + arr[right];
				int diff = Math.abs(sum - target);
				if (diff < minDifferene) {
					minDifferene = diff;
					closest = sum;
				}

				if (sum == target) {
					return closest;
				} else if (sum > target) {
					right--;
				} else {
					left++;
				}
			}
		}
		return closest;
	}

}
