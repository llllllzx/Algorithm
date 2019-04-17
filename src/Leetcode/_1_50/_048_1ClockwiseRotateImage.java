package Leetcode._1_50;

/**
 * 顺时针旋转90读
 * 
 * 
 * 
 * clockwise rotate
 * first reverse up to down, then swap the symmetry 
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
*
 * 
 * @author X6S
 *
 */
public class _048_1ClockwiseRotateImage {
	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		new _048_1ClockwiseRotateImage().rotate(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void rotate(int[][] matrix) {
		reverse(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[i].length; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
	}

	private void reverse(int[][] matrix) {
		for (int i = 0, j = matrix[0].length - 1; i <= j; i++, j--) {
			int[] tmp = matrix[i];
			matrix[i] = matrix[j];
			matrix[j] = tmp;
		}
	}

}
