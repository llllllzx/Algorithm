package Leetcode._51_100;

public class _058_LengthofLastWord {
	public static void main(String[] args) {
		//String s = "Hello World";
		String s = " ";
		int res = new _058_LengthofLastWord().lengthOfLastWord(s);
		System.out.println(res);
	}

	public int lengthOfLastWord(String str) {
		String s = str.trim();
		if(s == null || s.length() == 0) {
			return 0;
		}
		String[] split = s.split(" ");
		int length = split[split.length -1].length();
		return length;
	}
}
