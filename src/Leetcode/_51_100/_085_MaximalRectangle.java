package Leetcode._51_100;

public class _085_MaximalRectangle {
	public static void main(String[] args) {
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		int res = new _085_MaximalRectangle().maximalRectangle(matrix);
		System.out.println(res);
	}

	public int maximalRectangle(char[][] matrix) {
		int res = 0;
		int[] height = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
			}
			res = Math.max(res, findLargestRectangleArea(height));
		}
		return res;
	}

	private int findLargestRectangleArea(int[] height) {
		int res = 0;
		for (int i = 0; i < height.length; i++) {
			if (i + 1 > height.length && height[i + 1] >= height[i])
				continue;
			int minH = height[i];
			for (int j = i; j >= 0; j--) {
				minH = Math.min(minH, height[j]);
				int area = minH * (i - j + 1);
				res = Math.max(res, area);
			}
		}
		return res;
	}
}
