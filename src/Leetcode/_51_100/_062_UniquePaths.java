package Leetcode._51_100;

//	Input: m = 3, n = 2
//	Output: 3
//	Explanation:
//	From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
//	1. Right -> Right -> Down
//	2. Right -> Down -> Right
//	3. Down -> Right -> Right

/**
 * 
 * 维护一个二维数组dp，其中dp[i][j]表示到当前位置不同的走法的个数，
 * 然后可以得到递推式为: dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
 * @author X6S
 *
 */
public class _062_UniquePaths {
	public static void main(String[] args) {
		int m = 3, n = 7;
		int res = new _062_UniquePaths().uniquePaths(m, n);
		System.out.println(res);
	}

	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// 将第一行和第一列赋值为1.
				if (i == 0 || j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
	}
}
