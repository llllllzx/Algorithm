package Leetcode._51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
	Input: 3
	Output:
	[
	 [ 1, 2, 3 ],
	 [ 8, 9, 4 ],
	 [ 7, 6, 5 ]
	]
 * @author X6S
 *
 */
public class _059_SpiralMatrixII {
	public static void main(String[] args) {
		int n = 3;
		int[][] generateMatrix = new _059_SpiralMatrixII().generateMatrix(n);
		for (int i = 0; i < generateMatrix.length; i++) {
			for (int j = 0; j < generateMatrix.length; j++) {
				System.out.print(generateMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int[][] generateMatrix(int n) {
		// List<Integer> res = new ArrayList<>();
		int[][] arr = new int[n][n];
		int up = 0, down = n - 1, left = 0, right = n - 1;
		int num = 1;
		while (true) {
			for (int i = left; i <= right; i++) {
				arr[up][i] = num;
				num++;
			}
			if (++up > down)
				break;

			for (int i = up; i <= down; i++) {
				arr[i][right] = num;
				num++;
			}
			if (--right < left)
				break;

			for (int i = right; i >= left; i--) {
				arr[down][i] = num;
				num++;
			}
			if (--down < up)
				break;

			for (int i = down; i >= up; i--) {
				arr[i][left] = num;
				num++;
			}
			if (++left > right)
				break;
		}
		return arr;
	}
}
