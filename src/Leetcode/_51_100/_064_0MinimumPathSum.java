package Leetcode._51_100;

public class _064_0MinimumPathSum {
	public static void main(String[] args) {

		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		int res = new _064_0MinimumPathSum().minPathSum(grid);
		System.out.println(res);
	}

	public int minPathSum(int[][] grid) {
		if (grid == null || grid[0] == null) {
			return 0;
		}
		int n = grid.length;
		int m = grid[0].length;
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0 && j == 0) {
					arr[i][j] = grid[i][j];
				} else if (i == 0 && j > 0) {
					arr[i][j] = arr[i][j - 1] + grid[i][j];
				} else if (i > 0 && j == 0) {
					arr[i][j] = arr[i - 1][j] + grid[i][j];
				} else {
					arr[i][j] = Math.min(arr[i - 1][j], arr[i][j - 1]) + grid[i][j];
				}
			}
		}
		return arr[n - 1][m - 1];
	}
}
