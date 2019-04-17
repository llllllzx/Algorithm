package Leetcode._1_50;

import java.util.Scanner;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class _002AddTwoNumbers {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("请输入两个很大的整数，使用空格分开");
		String str1 = in.next();
		String str2 = in.next();
		// 转化为字符
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		// 创建单链表
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(0);
		ListNode u1 = l1, u2 = l2;
		// 初始化链表,反序
		for (int i = ch1.length - 1; i >= 0; i--) {
			l1.next = new ListNode(ch1[i] - '0');
			l1 = l1.next;
		}
		for (int j = ch2.length - 1; j >= 0; j--) {
			l2.next = new ListNode(ch2[j] - '0');
			l2 = l2.next;
		}

		ListNode dummyHead = new ListNode(0);
		ListNode p = u1.next, q = u2.next, curr = dummyHead;
		int carry = 0;

		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = x + y + carry;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}

		// 上面的while结束后，有可能还有进位。
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		ListNode res = dummyHead.next;
		String str = "";
		while (res != null) {
			str += res.val;
			res = res.next;
		}
		String re = new StringBuffer(str).reverse().toString();
		System.out.println(re);
	}
}
