package Leetcode._1_50;

/**
 * 逆时针旋转90度
 * 
 * anticlockwise rotate first reverse left to right, then swap the symmetry 1 2
 * 3 3 2 1 3 6 9 4 5 6 => 6 5 4 => 2 5 8 7 8 9 9 8 7 1 4 7
 * 
 * @author X6S
 */
public class _048_1AnticlockwiseRotateImage {
	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		new _048_1AnticlockwiseRotateImage().rotate(matrix);
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
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0, k = matrix[0].length - 1; j <= k; j++, k--) {
				int tmp = matrix[i][k];
				matrix[i][k] = matrix[i][j];
				matrix[i][j] = tmp;
			}
		}
	}
}
