package Leetcode._1_50;

public class _038_CountandSay {
	public static void main(String[] args) {
		String str = countAndSay(1);
		System.out.println(str);
	}

	public static String countAndSay(int n) {
		if (n <= 0) {
			return "";
		}
		String res = "1";
		// 从第二个开始count and say。
		for (int j = 1; j < n; j++) {
			// 设一个临时变量,用来记录
			String cur = "";

			// ###################代码核心。比如，res=1211,那么输出的cur=111221(1个1，1个2，2个1)
			for (int i = 0; i < res.length(); i++) {
				int cnt = 1;
				// 这个条件很关键也很巧妙。直接数每个字符出现多少次。
				while (i + 1 < res.length() && res.charAt(i) == res.charAt(i + 1)) {
					++cnt;
					++i;
				}
				cur += (cnt + "" + res.charAt(i));
			}
			// ###################

			res = cur;
		}
		return res;
	}
}
