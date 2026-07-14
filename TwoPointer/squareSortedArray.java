package TwoPointer;

import java.util.Scanner;

public class squareSortedArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of the array");
		int a = sc.nextInt();
		int arr[] = new int[a];
		
		System.out.println("Enter the elements");
		for(int i  = 0; i <= arr.length - 1; i++) {
			arr[i] = sc.nextInt();
		}
		
		int result[] = squareSorted(arr);
		for(int i = 0; i <= result.length - 1; i++) {
			System.out.print(result[i] + " ");
		}
		
		sc.close();
	}
	
	public static int[] squareSorted(int arr[]) {
		int nums[] = new int[arr.length];
		int index = nums.length - 1;
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) {
			if(Math.abs(arr[left]) > Math.abs(arr[right])) {
				nums[index] = arr[left] * arr[left];
				index--;
				left++;
			} else {
				nums[index] = arr[right] * arr[right];
				index--;
				right--;
			}
		}
		return nums;
	}
}
