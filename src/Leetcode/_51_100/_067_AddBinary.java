package Leetcode._51_100;

//	给定两个二进制字符串，返回他们的和（用二进制表示）。
//	输入为非空字符串且只包含数字 1 和 0。
//
//	输入: a = "11", b = "1"
//	输出: "100"
public class _067_AddBinary {
	public static void main(String[] args) {
//		String a = "1010";
//		String b = "1011";
		String a = "1";
		String b = "111";
		String res = new _067_AddBinary().addBinary(a, b);
		System.out.println(res);
	}

	public String addBinary(String a, String b) {
		int len1 = a.length() - 1;
		int len2 = b.length() - 1;
		StringBuffer sb = new StringBuffer();
		int carry = 0;
		while (len1 >= 0 && len2 >= 0) {
			int num1 = a.charAt(len1) - '0';
			int num2 = b.charAt(len2) - '0';
			sb.append((num1 + num2 + carry) % 2 + "");
			carry = (num1 + num2 + carry) / 2;
			len1--;
			len2--;
		}
		while (len1 >= 0) {
			int num1 = a.charAt(len1) - '0';
			sb.append((num1 + carry) % 2 + "");
			carry = (num1 + carry) / 2;
			len1--;

		}
		while (len2 >= 0) {
			int num2 = b.charAt(len2) - '0';
			sb.append((num2 + carry) % 2 + "");
			carry = (num2 + carry) / 2;
			len2--;

		}
		if (carry == 1) {
			sb.append(1 + "");
		}
		return sb.reverse().toString();
	}
}
