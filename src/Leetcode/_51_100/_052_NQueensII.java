package Leetcode._51_100;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;


public class _052_NQueensII {
	private static int count = 0;

	public static void main(String[] args) {
		int n = 8;
		int totalNQueens = new _052_NQueensII().totalNQueens(n);
		System.out.println(totalNQueens);
	}

	public int totalNQueens(int n) {
		// 初始化棋盘
		char[][] chess = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				chess[i][j] = '.';
			}
		}
		List<Integer> res = new ArrayList<>();
		helper(chess, 0,res);
		return res.size();
	}

	private void helper(char[][] chess, int row,List<Integer> res) {
		if (row == chess.length) {
			res.add(1);
			return;
		}
		
		char[][] chessTemp = chess.clone();
		
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess.length; j++) {
				chessTemp[row][j] = '.';
			}
			chessTemp[row][i] = 'Q';
			if (isValid(chessTemp, row, i)) {
				helper(chessTemp, row + 1,res);
			}
		}
	}

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
}
