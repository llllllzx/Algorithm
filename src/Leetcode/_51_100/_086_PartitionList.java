package Leetcode._51_100;

//	Input: head = 1->4->3->2->5->2, x = 3
//	Output: 1->2->2->4->3->5
public class _086_PartitionList {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		_086_PartitionList girl = new _086_PartitionList();
		int[] nums = { 1, 4, 3, 2, 5, 2 };
		ListNode head = girl.generateListNodeByArray(nums);
		ListNode res = girl.partition(head, 3);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}

	public ListNode partition(ListNode head, int target) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;

		ListNode q = new ListNode(-1);
		ListNode cur = q;
		while (head != null) {
			ListNode t = head.next;
			if (head.val < target) {
				p.next = head;
				p = p.next;
				// head.next = null;
			} else {
				q.next = head;
				q = q.next;
				// head.next = null;
			}
			head = t;
		}
		p.next = null;
		q.next = null;
		
		p.next = cur.next;
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
