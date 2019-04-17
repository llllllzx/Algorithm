package Leetcode._1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _049_GroupAnagrams {
	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> groupAnagrams = new _049_GroupAnagrams().groupAnagrams(strs);
		System.out.println(groupAnagrams);
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return new ArrayList<List<String>>();
		}

		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);

			String s = new String(charArray);
			if (!map.containsKey(s)) {
				map.put(s, new ArrayList<String>());
			}
			map.get(s).add(str);
		}
		// 将map中的value封装成一个集合。
		return new ArrayList<List<String>>(map.values());
	}
}
