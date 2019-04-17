package Leetcode._1_50;

public class _028_ImplementStrstr {
	public static void main(String[] args) {
		String haystack = "mississippi";
		String needle = "issip";
		int res = strStr(haystack, needle);
		System.out.println(res);
	}

	public static int strStr(String haystack, String needle) {
		if (haystack.length() < needle.length())
			return -1;
		if (!haystack.contains(needle))
			return -1;

		boolean flag = false;
		int count = 0;
		int res = 0;
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			int tmp = i;
			for (int j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i) != needle.charAt(j)) {
					break;
				} else {
					i++;
					count++;
					continue;
				}
			}
			i = tmp;
			if (count == needle.length()) {
				res = i;
				flag = true;
				break;
			}
			count = 0;
		}
		return flag == true ? res : -1;
	}
}
