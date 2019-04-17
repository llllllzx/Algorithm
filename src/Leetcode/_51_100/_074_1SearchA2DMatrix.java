package Leetcode._51_100;

import java.awt.HeadlessException;

public class _074_1SearchA2DMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		// int[][] matrix = {{1}};
		int target = 7;
		boolean res = new _074_1SearchA2DMatrix().searchMatrix(matrix, target);
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
				if (target == matrix[i][col - 1]) {
					return true;
				}
				index = i;
				break;
			}
		}
		return binarySearch(matrix, index, col, target);
	}

	public boolean binarySearch(int[][] matrix, int cow, int col, int target) {
		int low = 0;
		int high = col - 1;
		int middle = 0;
		while (low <= high) {
			middle = (low + high) / 2;
			if (matrix[cow][middle] < target) {
				low = middle + 1;
			} else if (matrix[cow][middle] > target) {
				high = middle - 1;
			} else {
				return true;
			}
		}
		return false;
	}
}
