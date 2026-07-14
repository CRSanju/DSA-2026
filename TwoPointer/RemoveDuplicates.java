package TwoPointer;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicates {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the length of the array");
		int a = scan.nextInt();
		int arr[] = new int[a];
		
		System.out.println("Enter the elements");
		for(int i  = 0; i <= arr.length - 1; i++) {
			arr[i] = scan.nextInt();
		}
		
		removeDuplicates(arr);
		
		scan.close();
	}
	
	public static void removeDuplicates(int arr[]) {
		int left = 0;
		int count = 1;
		int right = left + 1;
		while(right <= arr.length - 1) {
			if(arr[right] == arr[right - 1]) {
				right++;
			} else if(arr[right] != arr[right - 1]) {
				arr[left + 1] = arr[right];
				left++;
				right++;
				count++;
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(count);
		
	}
}
