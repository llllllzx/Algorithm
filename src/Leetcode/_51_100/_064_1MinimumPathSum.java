package Leetcode._51_100;

public class _064_1MinimumPathSum {
	public static void main(String[] args) {

		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		int res = new _064_1MinimumPathSum().minPathSum(grid);
		System.out.println(res);
	}

	public int minPathSum(int[][] grid) {
		if (grid == null || grid[0] == null) {
			return 0;
		}
		int n = grid.length;
		int m = grid[0].length;
		int[][] arr = new int[n][m];
		arr[0][0] = grid[0][0];
		for (int i = 1; i < n; i++) {
			arr[i][0] = arr[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < m; i++) {
			arr[0][i] = arr[0][i - 1] + grid[0][i];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				//arr[i][j] = Math.min(arr[i - 1][j], arr[i][j - 1]) + grid[i][j];
				arr[i][j] = Math.min(arr[i - 1][j], arr[i][j - 1]) + grid[i][j];
			}
		}
		return arr[n - 1][m - 1];
	}
}
