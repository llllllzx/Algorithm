package Leetcode._51_100;

import java.util.ArrayList;
import java.util.List;

//Input: "25525511135"
//Output: ["255.255.11.135", "255.255.111.35"]
public class _093_RestoreIPAddresses {
	public static void main(String[] args) {
		String s = "25525511135";
		_093_RestoreIPAddresses ya = new _093_RestoreIPAddresses();
		List<String> result = ya.restoreIpAddresses(s);
		System.out.println(result);
	}

	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();
		helper(s, res, 0, "");
		return res;
	}

	public void helper(String s, List<String> res, int n, String out) {
		if (n == 4) {
			if (s.isEmpty())
				res.add(out);
			return;
		} else {
			// 三个.将字符串分为四段，每一段字符串的长度可以为1 2 3
			for (int i = 1; i < 4; i++) {
				if (s.length() < i)
					break;
				int val = Integer.valueOf(s.substring(0, i));
				// 当只有一位时，0可以成某一段，如果有两位或三位时，像 00， 01， 001， 011， 000等都是不合法的。所以我们加上第二个判断条件
				if (val > 255 || i != String.valueOf(val).length())
					continue;
				helper(s.substring(i), res, n + 1, out + s.substring(0, i) + (n == 3 ? "" : "."));
			}
		}
	}
}
