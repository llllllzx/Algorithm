package Leetcode._1_50;

public class _021_MergeTwoSortedList {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1),curr = dummy;
		while (l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				curr.next = l1;
				l1 = l1.next;
			}else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		curr.next = (l1!=null ? l1:l2);
		return dummy.next;
	}
}
