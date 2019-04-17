package Leetcode._1_50;

import java.util.ArrayList;
import java.util.List;

public class _043_1MultiplyStrings {
	public static void main(String[] args) {
		// String num1 = "123456789", num2 = "987654321";
		String num1 = "2", num2 = "3";

		// System.out.println(num1 + "===>" + num2);
		String res = new _043_1MultiplyStrings().multiply(num1, num2);
		System.out.println(res);
	}

	public String multiply(String num1, String num2) {
		int m = num1.length(), n = num2.length();
		int[] pos = new int[m + n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int p1 = i + j, p2 = i + j + 1;
				int sum = mul + pos[p2];

				pos[p1] += sum / 10;
				//使用“=”而不是使用“+=”很巧妙。
				pos[p2] = sum % 10;

			}
		}
		StringBuilder sb = new StringBuilder();
		boolean flag = false;

		//这个方法比较好想
		for (int i = 0; i < pos.length; i++) {
			int p = pos[i];
			if (p == 0) {
				if (flag) {
					sb.append(p);
				} else {
					continue;
				}
			} else {
				sb.append(p);
				flag = true;
			}
		}
		//烧脑。
		// for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
		return sb.length() == 0 ? "0" : sb.toString();
	}
}
