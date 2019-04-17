package Leetcode._1_50;

public class _005_LongestPalindromicSubstring {
	public static void main(String[] args) {
		String str = longestPalindrome("babab");
		System.out.println(str);
	}

	public static String longestPalindrome(String s) {
		if (s.length() < 2)
			return s;
		
		int n = s.length(), maxLen = 0, start = 0;
		
		for (int i = 0; i < n;) {
			//判断剩余的字符串数是否小于等于maxLen的一半。就算是等于，也不用再考虑了，因为题目要求我们只需要找到一个最长的回文串。
			if (n - i <= maxLen / 2)
				break;
			
			int left = i, right = i;
			
			//向右遍历跳过重复项。例如noon,此时left指向第一个o,right指向第二个o。
			while (right < n - 1 && s.charAt(right + 1) == s.charAt(right))
				++right;
			
			
			//下一轮for循环从right的下一个字母开始。
			i = right + 1;
			
			//在right不指向最后一个元素，left不指向第一个元素的情况下，依次进行左右扩散。
			while (right < n - 1 && left > 0 && s.charAt(right + 1) == s.charAt(left - 1)) {
				++right;
				--left;
			}
			//如果此时回文串的长度大于之前回文串的长度。
			if (maxLen < right - left + 1) {
				//将最大长度进行重新赋值。
				maxLen = right - left + 1;
				//将回文串的开始位置进行更新。
				start = left;
			}
		}
		// return s.substr(start, maxLen);
		return s.substring(start, start+maxLen);
	}
}
