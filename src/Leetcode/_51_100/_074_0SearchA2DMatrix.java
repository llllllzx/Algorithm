package Leetcode._51_100;

import java.awt.HeadlessException;

public class _074_0SearchA2DMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		// int[][] matrix = {{1}};
		int target = 34;
		boolean res = new _074_0SearchA2DMatrix().searchMatrix(matrix, target);
		System.out.println(res);
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		int index = 0;
		for (int i = 0; i < row; i++) {
			if (target <= matrix[i][col - 1]) {
				index = i;
				break;
			}
		}
		for (int j = 0; j < col; j++) {
			if (matrix[index][j] == target) {
				return true;
			}
		}
		return false;
	}
}
