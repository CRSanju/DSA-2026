package TwoPointer;

import java.util.Scanner;

public class RemoveDuplicates2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of the array");
		int a = sc.nextInt();
		int arr[] = new int[a];
		
		System.out.println("Enter the elements");
		for(int i  = 0; i <= arr.length - 1; i++) {
			arr[i] = sc.nextInt();
		}
	}
	
	public static int removeDuplicatesTwo(int arr[]) {
		int left = 2;
		int right = 2;
		while(right <= arr.length - 1) {
			if(arr[right] != arr[left - 2]) {
				arr[left] = arr[right];
				left++;
			}
			right++;
		}
		return left;
	}

}
