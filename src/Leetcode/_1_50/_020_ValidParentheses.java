package Leetcode._1_50;

import java.util.Stack;

public class _020_ValidParentheses {
	public static void main(String[] args) {
		String s = "]";
		boolean b = isValid(s);
		System.out.println(b);
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			//只要是这三种符号，就进栈。
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				//如果是其他三种符号，首先我们得判断栈是否为空。
				if(stack.isEmpty()) return false;
				//注意pop()方法与peek()方法的区别。
				if (c == ')' && stack.pop() != '(')
					return false;
				if (c == '}' && stack.pop() != '{')
					return false;
				if (c == ']' && stack.pop() != '[')
					return false;
			}
		}
		return stack.isEmpty();
	}
}
