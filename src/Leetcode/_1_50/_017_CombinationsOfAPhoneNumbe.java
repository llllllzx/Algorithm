package Leetcode._1_50;

import java.util.ArrayList;
import java.util.List;

public class _017_CombinationsOfAPhoneNumbe {
	public static void main(String[] args) {
		List<String> list = letterCombinations("23");
		System.out.println(list);
	}

	public static List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits.isEmpty())
			return res;
		//首先定义一个字典
		String[] dict = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		//获取第一个数字对应的字符串。
		String firstStr = dict[digits.charAt(0) - '0'];
		char[] chars = firstStr.toCharArray();
		//这个地方待优化！！！！！！！！
		for(char c : chars) {
			res.add(c+"");
		}
		
		if(digits.length() == 1) {
			return res;
		}
		
		//从第二个数字开始遍历(在digits的长度大于2的前提下。)
		for (int i = 1; i < digits.length(); i++) {
			String str = dict[digits.charAt(i) - '0'];
			
			List<String> tmp = new ArrayList<>();
			//遍历手机按键上对应的字母
			for (int j = 0; j < str.length(); j++) {
				//遍历res列表，将按键上的字母依次加到其每个元素的后面存到tmp中，tmp是一个临时列表。
				for (String s : res) {
					tmp.add(s + str.charAt(j));
				}
			}
			//更新res列表。
			res = tmp;
		}
		return res;
	}
}
