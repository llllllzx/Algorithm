package Leetcode._1_50;

public class _044_WildcardMatching {
	public static void main(String[] args) {
		String s = "bbarc";
		// String p = "*c";
		// String p = "b*c";
		// String p = "b*arc";
		String p = "*c*";
		boolean flag = new _044_WildcardMatching().isMatch(s, p);
		System.out.println(flag);
	}

	public boolean isMatch(String s, String p) {
		// 分别记录s和p当前的位置。
		int sp = 0;
		int pp = 0;

		int match = 0;
		// 记录*所在的位置。
		int star = -1;

		while (sp < s.length()) {
			// 考虑两个字符串单个字符相匹配时的情况。
			if (pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')) {
				sp++;
				pp++;
			}
			// 当模式字符串为*时，使用star记录*的位置，使用match记录字符串s的匹配位置
			// 然后将模式字符串p的位置的位置进行加1，
			else if (pp < p.length() && p.charAt(pp) == '*') {
				star = pp;
				match = sp;
				pp++;
				// 如果此时*已经赋了值，模式串p指向*的下一个位置。然后字符串s的匹配位置也后移一位，并将匹配位置赋给sp.
			} else if (star != -1) {
				pp = star + 1;
				match++;
				sp = match;
			} else
				return false;
		}
		//
		while (pp < p.length() && p.charAt(pp) == '*') {
			pp++;
		}
		return pp == p.length();
	}
}
