package Leetcode._1_50;

import java.util.Stack;

public class _032_LongestValidParentheses {
	public static void main(String[] args) {
		String str = "()((())()()))()()";
		int a = longestValidParentheses(str);
		System.out.println(a);
	}

	public static int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		char[] chars = s.toCharArray();
		int n = chars.length;
		int longest = 0;
		for (int i = 0; i < n; i++) {
			if (chars[i] == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					stack.push(i);
				} else {
					if (chars[stack.peek()] == '(') {
						stack.pop();
					} else {
						stack.push(i);
					}
				}
			}
		}

		if (stack.isEmpty())
			longest = n;
		else {
			int a = n, b = 0;
			while (!stack.isEmpty()) {
				b = stack.pop();
				longest = Math.max(longest, a - b - 1);
				a = b;
			}
			longest = Math.max(longest, a);
		}

		return longest;
	}
}
