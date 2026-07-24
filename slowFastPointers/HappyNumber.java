package slowFastPointers;

public class HappyNumber {

	public static boolean isHappy(int n) {
		int slow = n;
		int fast = n;
		while (true) {
			slow = addSum(slow);
			fast = addSum(fast);
			fast = addSum(fast);
			if (fast == 1) {
				return true;
			}

			if (slow == fast) {
				return false;
			}
		}
	}

	public static int addSum(int n) {

		int sum = 0;
		while (n > 0) {
			int dig = n % 10;
			n = n / 10;
			sum = sum + dig * dig;
		}

		return sum;
	}

	public static void main(String[] args) {

		int n = 19;

		System.out.println(isHappy(n));

	}

}
