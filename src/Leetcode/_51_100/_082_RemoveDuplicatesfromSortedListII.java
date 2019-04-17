package Leetcode._51_100;

//	Input: 1->2->3->3->4->4->5
//	Output: 1->2->5
public class _082_RemoveDuplicatesfromSortedListII {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// int[] nums = { 1, 2, 3, 3, 4, 4, 5 };
		int[] nums = { 1, 2, 2 };
		_082_RemoveDuplicatesfromSortedListII girl = new _082_RemoveDuplicatesfromSortedListII();
		ListNode head = girl.generateListNodeByArray(nums);
		ListNode res = girl.deleteDuplicates(head);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;
		boolean flag = true;
		while (head != null) {
			ListNode t = head.next;
			while (t != null && t.val == head.val) {
				t = t.next;
				flag = false;
			}
			if (flag) {
				p.next = head;
				p = p.next;
				p.next = null;// 这句很重要。每次接上一个ListNode以后，将其next置为null.
			}
			head = t;
			flag = true;
		}
		return dummy.next;
	}
	// 题意理解错了，此算法是将重复的元素只输出一个，而不是删除重复元素。
	// public ListNode deleteDuplicates(ListNode head) {
	// if (head == null) {
	// return head;
	// }
	// ListNode dummy = head, p = head;
	// while (p != null) {
	// ListNode t = p.next;
	// while (t != null && t.val == p.val) {
	// t = t.next;
	// }
	// p.next = t;
	// p = t;
	// }
	//
	// return dummy;
	// }

	/**
	 * 生成链表
	 * @param nums
	 * @return
	 */
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
