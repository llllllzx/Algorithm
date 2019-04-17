package Leetcode._1_50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _030_SubstringWithConcatenationofAllWords {
	public static void main(String[] args) {
		// String s = "barthefoobarman";
		// String[] words = { "foo", "bar" };

		String s = "wordgoodgoodgoodbestword";
		String[] words = { "word", "good", "best", "word" };
		List list = findSubstring(s, words);
		System.out.println(list);
	}

	public static List<Integer> findSubstring(String s, String[] words) {
		if (s.isEmpty() || words.length == 0)
			return null;
		// 创建单词哈希表。
		final Map<String, Integer> counts = new HashMap<>();

		// 将单词作为key,出现的次数作为value，存到一个hashmap中。
		for (final String word : words) {
			// 当Map集合中有这个key时，就使用这个key值，如果没有就使用默认值defaultValue
			counts.put(word, counts.getOrDefault(word, 0) + 1);
		}
		final List<Integer> indexes = new ArrayList<>();
		// 得到字符串的长度；字符数组的长度；还有单词的长度。
		final int n = s.length(), num = words.length, len = words[0].length();

		// 依次遍历，停止条件为当剩余字符个数小于单词集里所有字符的长度
		for (int i = 0; i < n - num * len + 1; i++) {
			// 再次申请一个hashmap。
			final Map<String, Integer> seen = new HashMap<>();
			int j = 0;

			for (j = 0; j < num; j++) {
				final String word = s.substring(i + j * len, i + (j + 1) * len);
				// 如果这个单词在单词哈希表中
				if (counts.containsKey(word)) {

					seen.put(word, seen.getOrDefault(word, 0) + 1);

					// 着一条语句的作用是什么呢
					//看看本题的测试用例，当字符串s中的第二个good进行匹配的时候，在seen中{good,2}，但是在count中{good,1}.此时是不符合题意的。
					if (seen.get(word) > counts.getOrDefault(word, 0)) {
						break;
					}
				} else {
					break;
				}
			}
			//如果在字符串s中，检测单词的个数，与words中单词的个数相等，则符合题目要求。
			if (j == num) {
				indexes.add(i);
			}
		}
		return indexes;
	}
}
