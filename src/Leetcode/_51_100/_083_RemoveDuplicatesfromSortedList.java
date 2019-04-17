package Leetcode._51_100;

//	Input: 1->1->2->3->3
//	Output: 1->2->3
public class _083_RemoveDuplicatesfromSortedList {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 3, 3 };
		_083_RemoveDuplicatesfromSortedList girl = new _083_RemoveDuplicatesfromSortedList();
		ListNode head = girl.generateListNodeByArray(nums);
		ListNode res = girl.deleteDuplicates(head);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = head, p = head;
		while (p != null) {
			ListNode t = p.next;
			while(t != null && p.val == t.val) {
				t = t.next;
			}
			p.next = t;
			p = t;
		}
		return dummy;
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
