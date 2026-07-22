package SlidingWindow;

import java.util.HashMap;
import java.util.Scanner;

public class longestSubstringWithKUnique {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the String");
		String s = sc.next();

		System.out.println("Enter the unique elements");
		int k = sc.nextInt();

		int result = longestSubstring(s, k);
		System.out.println(result);

		sc.close();

	}

	public static int longestSubstring(String s, int k) {

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int left = 0;
		int maxWin = -1;

		for (int right = 0; right < s.length(); right++) {
			char rf = s.charAt(right);
			map.put(rf, map.getOrDefault(rf, 0) + 1);

			while (map.size() > k) {
				char lf = s.charAt(left);
				map.put(lf, map.get(lf) - 1);

				if (map.get(lf) == 0) {
					map.remove(lf);
				}
				left++;
			}
			if (map.size() == k) {
				maxWin = Math.max(maxWin, right - left + 1);
			}
		}

		return maxWin;

	}

}
