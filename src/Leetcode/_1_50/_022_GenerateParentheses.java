package Leetcode._1_50;

import java.util.ArrayList;
import java.util.List;

public class _022_GenerateParentheses {
	public static void main(String[] args) {

	}

	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		helper(n, n, "", res);
		return res;
	}

	public static void helper(int left, int right, String out, List<String> res) {
		// 在递归的过程中，如果左括号的个数大于右括号的个数，说明此时生成的字符串中，右括号的个数大于左括号的个数。势必会出现“)(”这样的的结果。
		if (left < 0 || right < 0 || left > right)
			return;
		//如果left与right都为0，此时生成的字符串中已经有三个左括号和三个右括号，且字符串合法。
		if (left == 0 && right == 0) {
			res.add(out);
			return;
		}
		
		helper(left - 1, right, out + "(", res);
		helper(left, right - 1, out + ")", res);

	}
}
