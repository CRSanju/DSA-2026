package slowFastPointers;

public class LinkedListCycleII {

	public static ListNode detectCycle(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				slow = head;
				while (fast != slow) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}

		return null;
	}

	public static void main(String[] args) {

		ListNode head = new ListNode(3);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(0);
		ListNode fourth = new ListNode(-4);

		head.next = second;
		second.next = third;
		third.next = fourth;

		// Create cycle
		fourth.next = second;

		ListNode cycleStart = detectCycle(head);

		if (cycleStart != null) {
			System.out.println("Cycle starts at node: " + cycleStart.val);
		} else {
			System.out.println("No cycle");
		}
	}
}
