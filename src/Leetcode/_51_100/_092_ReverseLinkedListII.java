package Leetcode._51_100;

public class _092_ReverseLinkedListII {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		_092_ReverseLinkedListII ya = new _092_ReverseLinkedListII();
		ListNode head = ya.generateListNodeByArray(nums);
		ListNode res = ya.reverseBetween(head, 2, 4);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = dummy;
		ListNode pre, last;
		ListNode front = null;
		for (int i = 1; i <= m - 1; i++)
			cur = cur.next;
		pre = cur;
		last = cur.next;
		for (int i = m; i <= n; ++i) {
			cur = pre.next;
			pre.next = cur.next;
			cur.next = front;
			front = cur;
		}
		cur = pre.next;
		pre.next = front;
		last.next = cur;
		return dummy.next;
	}

	public ListNode generateListNodeByArray(int[] nums) {
		ListNode head = new ListNode(-1);
		ListNode dummy = head;
		for (int i = 0; i < nums.length; i++) {
			head.next = new ListNode(nums[i]);
			head = head.next;
		}
		return dummy.next;
	}
}
