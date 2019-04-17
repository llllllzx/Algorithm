package Leetcode._1_50;

import java.util.ArrayList;
import java.util.List;

public class _043_0MultiplyStrings {
	public static void main(String[] args) {
		// String num1 = "123456789", num2 = "987654321";
		String num1 = "123456789", num2 = "987654321";

		// System.out.println(num1 + "===>" + num2);
		String res = new _043_0MultiplyStrings().multiply(num1, num2);
		System.out.println(res);
	}

	public String multiply(String num1, String num2) {
		if ("0".equals(num1) || "0".equals(num2)) {
			return "0";
		}
		int n1 = num1.length();
		int n2 = num2.length();
		String sum = "0";
		int carry = 0;
		int mul = 0;
		List<String> resList = new ArrayList<>();
		for (int i = n1 - 1; i >= 0; i--) {
			int a = num1.charAt(i) - '0';
			List<Integer> list = new ArrayList<>();
			for (int j = n2 - 1; j >= 0; j--) {
				int b = num2.charAt(j) - '0';
				mul = a * b;
				int re = (mul + carry) % 10;
				carry = (mul + carry) / 10;
				list.add(re);
			}
			if (carry != 0) {
				list.add(carry);
			}
			carry = 0;
			String str = "";
			for (int k = list.size() - 1; k >= 0; k--) {
				str += list.get(k);
			}
			resList.add(str);
		}
		String tmp = "";
		for (int i = 0; i < resList.size(); i++) {
			for (int j = 0; j < i; j++) {
				tmp += "0";
			}

			String s = resList.get(i) + tmp;
			sum = addTwoSum(sum, s);

			System.out.println(s);
			tmp = "";
		}
		System.out.println(resList);
		return sum;
	}

	public String addTwoSum(String str1, String str2) {
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
		return re;
	}

}
