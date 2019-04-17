package Leetcode._1_50;

public class _006_ZigzagConversion {
	public static void main(String[] args) {
		String str = convert("PAYPALISHIRING", 3);
		System.out.println(str);
	}

	public static String convert(String s, int numRows) {
		if (numRows <= 1)
			return s;

		String res = "";
		int size = 2 * numRows - 2;
		for (int i = 0; i < numRows; i++) {
			for (int j = i; j < s.length(); j += size) {
				res += s.charAt(j);
				
				//通过观察，找规律得出来的。
				int tmp = j + size - 2 * i;
				
				//除了第一行和最后一行，其他行将数据进行插入。
				if (i != 0 && i != numRows - 1 && tmp < s.length()) {
					res += s.charAt(tmp);
				}
			}
		}
		return res;
	}
}
