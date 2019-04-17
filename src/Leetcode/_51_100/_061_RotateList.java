package Leetcode._51_100;

public class _061_RotateList {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// int[] nums = { 1, 2, 3, 4, 5 };
		int[] nums = { 1, 2 };
		ListNode head = new ListNode(-1);
		ListNode p = head;
		for (int i = 0; i < nums.length; i++) {
			ListNode node = new ListNode(nums[i]);
			p.next = node;
			p = p.next;
		}
		int k = 3;
		ListNode res = new _061_RotateList().rotateRight(head.next, k);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}

	// Input: 1->2->3->4->5->NULL, k = 2
	// Output: 4->5->1->2->3->NULL
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return head;
		}
		int len = 0;
		ListNode p = head;
		while (p != null) {
			len++;
			p = p.next;
		}
		int n = k % len;
		// 如果移动是长度是链表长度的整数倍，直接返回原链表。
		if (n == 0) {
			return head;
		}
		int l = len - n - 1;
		ListNode dummy = head, curr = head;
		while (l >= 1) {
			curr = curr.next;
			l--;
		}
		ListNode t = curr.next, res = curr.next;
		curr.next = null;
		while (t.next != null) {
			t = t.next;
		}
		t.next = dummy;
		return res;
	}
}
