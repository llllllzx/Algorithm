package Leetcode._1_50;

public class _019_RemoveNthNodeFromEndofList {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4, 5 };
		ListNode nodes = new ListNode(0);
		ListNode li = nodes;
		for (int i = 0; i < nums.length; i++) {
			li.next = new ListNode(nums[i]);
			li = li.next;
		}
		ListNode li2 = nodes.next;
		ListNode listN = removeNthFromEnd(li2, 2);
		while (listN != null) {
			System.out.println(listN.val);
			listN = listN.next;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head.next == null) {
			return null;
		}
		ListNode curr = head;
		ListNode pre = head;
		for (int i = 0; i < n; i++) {
			curr = curr.next;
		}
		if (curr == null)
			return head.next;
		while (curr.next != null) {
			curr = curr.next;
			pre = pre.next;
		}
		pre.next = pre.next.next;
		return head;
	}
}
