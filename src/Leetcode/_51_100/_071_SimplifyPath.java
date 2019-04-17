package Leetcode._51_100;

import java.util.Stack;

public class _071_SimplifyPath {
	public static void main(String[] args) {
		// String res = new _071_SimplifyPath().simplifyPath("/a/../../../b/../c//.//");
		// String res = new _071_SimplifyPath().simplifyPath("/a//b////c/d//././/..");
		String res = new _071_SimplifyPath().simplifyPath("/.");
		System.out.println(res);
	}

	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		String[] fields = path.split("/");
		for (int i = 0; i < fields.length; i++) {
			// 只有不等于null的时候才进行处理。
			if (!fields[i].isEmpty()) {
				// 栈为空的时候，直接进栈
				if (stack.isEmpty()) {
					stack.push(fields[i]);
				} else {// 栈不为空时
					if (fields[i].equals("..")) {
						stack.pop();
					} else if (!fields[i].equals(".")) {
						stack.push(fields[i]);
					}
				}
			}
		}
		// System.out.println (stack);
		StringBuilder sb = new StringBuilder();
		// System.out.println(stack.size());
		sb.append("/");
		for (String str : stack) {
			if (!str.equals("..") && !str.equals(".")) {
				sb.append(str + "/");
			}
		}
		int n = sb.length();
		if (n > 1) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
}
