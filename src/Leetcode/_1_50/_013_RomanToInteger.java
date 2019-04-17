package Leetcode._1_50;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _013_RomanToInteger {
	public static void main(String[] args) {
		//String s = "MCMXCIV";
		String s = "LVIII";
		if (s.length() == 0 || s == null) {
			return;
		}
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int length = s.length();
		char[] chs = s.toCharArray();
		int result = map.get(chs[length - 1]);
		for (int i = length - 2; i >= 0; i--) {
			if (map.get(chs[i]) >= map.get(chs[i + 1])) {
				result += map.get(chs[i]);
			} else {
				result -= map.get(chs[i]);
			}
		}
		System.out.println(result);
	}
}
