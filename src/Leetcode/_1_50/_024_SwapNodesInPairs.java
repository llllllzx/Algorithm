package Leetcode._1_50;

public class _024_SwapNodesInPairs {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6 };
		ListNode li = new ListNode(-1);
		ListNode curr = li;
		for (int i = 0; i < array.length; i++) {
			curr.next = new ListNode(array[i]);
			curr = curr.next;
		}
		ListNode res = swapPairs(li.next);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	public static ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(-1);
		ListNode pre = dummy;
		dummy.next = head;
		while ( pre.next != null&&pre.next.next != null) {
			ListNode tmp = pre.next.next;
			pre.next.next = tmp.next;
			tmp.next = pre.next;
			pre.next = tmp;
			pre = tmp.next;
		}
		return dummy.next;
	}
}
