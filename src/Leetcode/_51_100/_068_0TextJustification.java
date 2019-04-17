package Leetcode._51_100;

import java.util.ArrayList;
import java.util.List;

public class _068_0TextJustification {
	public static void main(String[] args) {
		String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
		int maxWidth = 20;
		List<String> res = new _068_0TextJustification().fullJustify(words, maxWidth);
		System.out.println(res);
	}

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<>();
		int index = 0;
		while (index < words.length) {
			int count = words[index].length();
			int last = index + 1;
			while (last < words.length) {
				if (words[last].length() + count + 1 > maxWidth)
					break;
				count += 1 + words[last].length();
				last++;
			}
			StringBuilder builder = new StringBuilder();
			builder.append(words[index]);
			int diff = last - index - 1;
			if (last == words.length || diff == 0) {
				for (int i = index + 1; i < last; i++) {
					builder.append(" ");
					builder.append(words[i]);
				}
				for (int i = builder.length(); i < maxWidth; i++) {
					builder.append(" ");
				}
			} else {
				int spaces = (maxWidth - count) / diff;
				int r = (maxWidth - count) % diff;
				for (int i = index + 1; i < last; i++) {
					for (int k = spaces; k > 0; k--) {
						builder.append(" ");
					}
					if (r > 0) {
						builder.append(" ");
						r--;
					}
					builder.append(" ");
					builder.append(words[i]);
				}
			}
			res.add(builder.toString());
			index = last;
		}
		return res;
	}

}
