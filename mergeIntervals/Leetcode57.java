package mergeIntervals;

import java.util.*;

public class Leetcode57 {

	public static void main(String[] args) {

		int[][] intervals = { { 1, 3 }, { 6, 9 } };

		int[] newInterval = { 2, 5 };

		int[][] result = insert(intervals, newInterval);

		for (int[] interval : result) {
			System.out.println(Arrays.toString(interval));
		}
	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {

		// This is the first part where you sort and merge two different arrays into one
		int[][] newIntervals = new int[intervals.length + 1][];
		boolean insert = false;
		int j = 0;
		for (int i = 0; i < newIntervals.length; i++) {
			if (insert == false && j < intervals.length && newInterval[0] <= intervals[j][0]) {
				newIntervals[i] = newInterval;
				insert = true;
			} else if (j < intervals.length) {
				newIntervals[i] = intervals[j];
				j++;
			} else {
				newIntervals[i] = newInterval;
			}
		}

		// Merge the intervals together and make it one
		List<int[]> merged = new ArrayList<>();
		int[] prev = newIntervals[0];
		for (int i = 1; i < newIntervals.length; i++) {
			int[] interval = newIntervals[i];
			if (interval[0] <= prev[1]) {
				prev[1] = Math.max(interval[1], prev[1]);
			} else {
				merged.add(prev);
				prev = interval;
			}
		}

		merged.add(prev);
		return merged.toArray(new int[merged.size()][]);
	}
}
