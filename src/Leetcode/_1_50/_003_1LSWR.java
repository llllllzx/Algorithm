package Leetcode._1_50;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _003_1LSWR {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0,i = 0,j = 0;
		while(i < n && j < n) {
			if(!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			}else {
				set.remove(s.charAt(i++));
			}
		}
		System.out.println(ans);
	}
}
