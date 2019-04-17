package Leetcode._51_100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _084_LargestRectangleinHistogram {
	public static void main(String[] args) {
		int[] heights = { 2, 1, 5, 6, 2, 3 };
		int res = new _084_LargestRectangleinHistogram().largestRectangleArea(heights);
		System.out.println(res);
	}

	public int largestRectangleArea(int[] heights) {
		int res = 0;
		for (int i = 0; i < heights.length; i++) {
			if (i + 1 < heights.length && heights[i + 1] >= heights[i]) {
				continue;
			}
			int minH = heights[i];
			for (int j = i; j >= 0; j--) {
				minH = Math.min(minH, heights[j]);
				int area = minH * (i - j + 1);
				res = Math.max(area, res);
			}
		}
		return res;
	}
}
