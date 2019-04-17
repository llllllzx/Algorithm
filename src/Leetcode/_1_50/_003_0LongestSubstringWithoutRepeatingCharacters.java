package Leetcode._1_50;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/**
 * 此方法的时间复杂度太大了。
 * @author X6S
 *
 */
public class _003_0LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int n = s.length();
		int ans = 0;// 考虑到空的字符串,所以应该初始化为0而不是1.
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (allUnique(s, i, j)) {
					ans = Math.max(ans, j - i);
				}
			}
		}
		System.out.println(ans);
	}

	public static boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for (int i = start; i < end; i++) {
			Character ch = s.charAt(i);
			if (set.contains(ch))
				return false;
			set.add(ch);
		}
		return true;

	}
}
