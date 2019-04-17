package Leetcode._1_50;

public class _008_StringtoInteger_atoi {
	public static final int INT_MAX = 2147483647;
	public static final int INT_MIN = -2147483648;

	public static void main(String[] args) {
		// int res = myAtoi("-91283472332");
		//int res = myAtoi("words and 987");
		int res = myAtoi("4193 with words");
		System.out.println(res);
	}

	public static int myAtoi(String str) {
		// 字符串转字符数组
		char[] chs = str.toCharArray();
		// 去除空格
		int index = 0;
		while (index < str.length() && chs[index] == ' ')
			index++;
		// 设置flag,判断正负号
		int flag = 1;
		if (index < str.length() && chs[index] == '-') {
			flag = -1;
			index++;
		} else if (index < str.length() && chs[index] == '+') {
			index++;
		}
		// 计算结果
		long res = 0L;//预防越界。
		while (index < str.length()) {
			if (chs[index] < '0' || chs[index] > '9') {

				return (int) (flag == -1 ? -res : res);
			}
			int digit = chs[index] - '0';
			if (flag == 1 && res * 10 + digit > INT_MAX) {
				return INT_MAX;
			} else if (flag == -1 && -(res * 10 + digit) < INT_MIN) {
				return INT_MIN;
			}

			res = res * 10 + digit;
			index++;
		}
		return (int) (flag == -1 ? -res : res);

	}
}
