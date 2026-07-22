package SlidingWindow;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubstringWithoutRepeating {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the String");
		String s = sc.next();

		int res = lengthOfLongestSubstring(s);
		System.out.println(res);
		sc.close();
	}

	public static int lengthOfLongestSubstring(String s) {

		HashMap<Character, Integer> map = new HashMap<>();
		int left = 0;
		int maxVal = 0;
		for (int right = 0; right < s.length(); right++) {
			map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

			while (map.get(s.charAt(right)) > 1) {
				map.put(s.charAt(left), map.get(s.charAt(left)) - 1);

				if (map.get(s.charAt(left)) == 0) {
					map.remove(s.charAt(left));
				}

				left++;
			}

			maxVal = Math.max(maxVal, right - left + 1);
		}

		return maxVal;
	}
}
