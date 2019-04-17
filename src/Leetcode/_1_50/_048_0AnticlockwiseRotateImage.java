package Leetcode._1_50;
/**
 * 逆时针旋转90度
 * @author X6S
 *
 */
public class _048_0AnticlockwiseRotateImage {
	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		new _048_0AnticlockwiseRotateImage().rotate(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void rotate(int[][] matrix) {
		int n1 = matrix.length;
		int n2 = matrix[0].length;
		int[][] tmp = new int[n1][n2];
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n2; j++) {
				tmp[n1-1-j][i] = matrix[i][j];
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = tmp[i][j];
			}
		}
	}
}
