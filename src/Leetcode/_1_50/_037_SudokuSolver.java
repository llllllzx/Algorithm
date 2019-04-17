package Leetcode._1_50;

public class _037_SudokuSolver {
	public static void main(String[] args) {
		char[][] sudo = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		solve(sudo);
		for(int i = 0;i<sudo.length;i++) {
			for(int j =0;j<sudo[0].length;j++) {
				System.out.print(sudo[i][j]+" ");
			}
			System.out.println();
		}
	}

	
	
	public static void solveSudoku(char[][] board) {
		if (board == null || board.length == 0)
			return;
		solve(board);
	}

	public static boolean solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {// trial. Try 1 through 9
						if (isValid(board, i, j, c)) {
							board[i][j] = c; // Put c for this cell

							if (solve(board))
								return true; // If it's the solution return true
							else
								board[i][j] = '.'; // Otherwise go back
						}
					}

					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * @param board
	 * @param row
	 * @param col
	 * @param c
	 * @return
	 */
	private static boolean isValid(char[][] board, int row, int col, char c) {
		for (int i = 0; i < 9; i++) {
			if (board[i][col] != '.' && board[i][col] == c)
				return false; // check row
			if (board[row][i] != '.' && board[row][i] == c)
				return false; // check column
			
			if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
					&& board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
				return false; // check 3*3 block
		}
		return true;
	}
}
