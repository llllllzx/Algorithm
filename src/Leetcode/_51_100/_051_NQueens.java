package Leetcode._51_100;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 构建二维int或者short型数组，内存中模拟棋盘
chess[r][c]='.'表示：r行c列没有皇后，chess[r][c]='Q'表示：r行c列位置有一个皇后
从第一行第一列开始逐行摆放皇后
依题意每行只能有一个皇后，遂逐行摆放，每行一个皇后即可
摆放后立即调用一个验证函数（传递整个棋盘的数据），验证合理性，安全则摆放下一个，不安全则尝试摆放这一行的下一个位置，直至摆到棋盘边界
当这一行所有位置都无法保证皇后安全时，需要回退到上一行，清除上一行的摆放记录，并且在上一行尝试摆放下一位置的皇后（回溯算法的核心）
当摆放到最后一行，并且调用验证函数确定安全后，累积数自增1，表示有一个解成功算出
验证函数中，需要扫描当前摆放皇后的左上，中上，右上方向是否有其他皇后，有的话存在危险，没有则表示安全，并不需要考虑当前位置棋盘下方的安全性，因为下面的皇后还没有摆放
 * @author X6S
 *
 */
public class _051_NQueens {
	public static void main(String[] args) {
		Date start = new Date();
		int n = 8;
		List<List<String>> solveNQueens = new _051_NQueens().solveNQueens(n);
		System.out.println(solveNQueens);
		Date end = new Date();
		System.out.println("耗时:" + String.valueOf(end.getTime() - start.getTime()));
	}

	public List<List<String>> solveNQueens(int n) {
		//初始化棋盘
		char[][] chess = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				chess[i][j] = '.';
			}
		}
		List<List<String>> res = new ArrayList<>();
		helper(chess, 0, res);
		return res;
	}

	private void helper(char[][] chess, int row, List<List<String>> res) {
		// 如果row == chess.length,说明已经成功将所有皇后摆放完毕。
		if (row == chess.length) {
			res.add(construct(chess));
			return;
		}
		//克隆一个临时棋盘。
		char[][] chessTemp = chess.clone();
		/**
		 * 向这一行的每一个位置尝试排放皇后
         * 然后检测状态，如果安全则继续执行递归函数摆放下一行皇后
         * 
		 */
		for (int i = 0; i < chess.length; i++) {
			// 防止污染棋盘
			for (int j = 0; j < chess.length; j++) {
				chessTemp[row][j] = '.';
			}
			chessTemp[row][i] = 'Q';
			if (isValid(chessTemp, row, i)) {
				helper(chessTemp, row + 1, res);
			}
		}
	}

	/**
	 * 判断皇后的位置是否有效
	 * 
	 * @param chess
	 * @param row
	 * @param col
	 * @return
	 */
	private boolean isValid(char[][] chess, int row, int col) {
		int step = 1;
		while (row - step >= 0) {
			if (chess[row - step][col] == 'Q') // 中上
				return false;
			if (col - step >= 0 && chess[row - step][col - step] == 'Q') // 左上
				return false;
			if (col + step < chess.length && chess[row - step][col + step] == 'Q') // 右上
				return false;

			step++;
		}
		return true;
	}

	/**
	 * 
	 * 结构化结果。
	 * @param chess
	 * @return
	 */
	private List<String> construct(char[][] chess) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < chess.length; i++) {
			String s = new String(chess[i]);
			res.add(s);
		}
		return res;
	}
}
