package SlidingWindow;

import java.util.HashMap;
import java.util.Scanner;

public class CharacterReplacement {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the string: ");
		String s = sc.nextLine();

		System.out.print("Enter k: ");
		int k = sc.nextInt();

		int result = characterReplacement(s, k);

		System.out.println("Answer: " + result);

		sc.close();
	}

	public static int characterReplacement(String s, int k) {

		HashMap<Character, Integer> map = new HashMap<>();
		int left = 0;
		int maxCount = 0;
		int maxLength = 0;
		for (int right = 0; right < s.length(); right++) {
			map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

			maxCount = Math.max(maxCount, map.get(s.charAt(right)));

			while ((right - left + 1) - maxCount > k) {
				map.put(s.charAt(left), map.get(s.charAt(left)) - 1);

				if (map.get(s.charAt(left)) == 0) {
					map.remove(s.charAt(left));
				}

				left++;
			}

			maxLength = Math.max(maxLength, right - left + 1);
		}

		return maxLength;
	}

}
