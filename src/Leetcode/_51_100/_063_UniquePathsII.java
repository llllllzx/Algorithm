package Leetcode._51_100;
//	输入:

//	[
//	  [0,0,0],
//	  [0,1,0],
//	  [0,0,0]
//	]
//	输出: 2
//	解释:
//	3x3 网格的正中间有一个障碍物。
//	从左上角到右下角一共有 2 条不同的路径：
//	1. 向右 -> 向右 -> 向下 -> 向下
//	2. 向下 -> 向下 -> 向右 -> 向右

/**
 * 这道题是第62题的延伸，在路径中加了一些障碍物，
 * 还是用动态规划Dynamic Programming来解，
 * 不同的是当遇到为1的点，将该位置的dp数组中的值清零，其余和第62道题并没有什么区别
 * @author X6S
 *
 */
public class _063_UniquePathsII {
	public static void main(String[] args) {

		int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int res = new _063_UniquePathsII().uniquePathsWithObstacles(obstacleGrid);
		System.out.println(res);
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid[0] == null || obstacleGrid[0][0] == 1) {
			return 0;
		}
		int n = obstacleGrid.length;
		int m = obstacleGrid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 如果有障碍物，则在该位置赋值0
				if (obstacleGrid[i][j] == 1) {
					obstacleGrid[i][j] = 0;
				} else if (i == 0 && j == 0) {//这一句必须写在这里。
					obstacleGrid[i][j] = 1;
				} else if (i == 0 && j > 0) {
					obstacleGrid[i][j] = obstacleGrid[i][j - 1];
				} else if (j == 0 && i > 0) {
					obstacleGrid[i][j] = obstacleGrid[i - 1][j];
				} else {
					obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
				}
			}

		}
		return obstacleGrid[n - 1][m - 1];
	}
}
