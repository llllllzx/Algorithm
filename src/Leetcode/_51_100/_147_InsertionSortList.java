package Leetcode._51_100;

public class _147_InsertionSortList {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 6, 5, 3, 1, 8, -7, -2, -4 };
		ListNode head = new ListNode(-1);
		ListNode p = head;
		for (int i = 0; i < nums.length; i++) {
			ListNode node = new ListNode(nums[i]);
			p.next = node;
			p = p.next;
		}
		ListNode t = head.next;
		while (t != null) {
			System.out.print(t.val + " ");
			t = t.next;
		}
		System.out.println();
		ListNode res = new _147_InsertionSortList().insertionSortList(head.next);
		ListNode tt = res;
		while (tt != null) {
			System.out.print(tt.val + " ");
			tt = tt.next;
		}
	}

	public ListNode insertionSortList(ListNode head) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		while (head != null) {
			// 保存head节点的下一个节点的地址。
			ListNode t = head.next;
			// 从头开始遍历，查找节点插入的位置。
			cur = dummy;
			// 寻找节点插入的位置。
			while (cur.next != null && cur.next.val <= head.val) {
				cur = cur.next;
			}
			// 将节点插入到dummy链表中
			head.next = cur.next;
			cur.next = head;
			// head后移
			head = t;
		}
		return dummy.next;
	}
}
