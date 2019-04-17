package Leetcode._51_100;

/*	board =
	[
	  ['A','B','C','E'],
	  ['S','F','C','S'],
	  ['A','D','E','E']
	]
	
	Given word = "ABCCED", return true.
	Given word = "SEE", return true.
	Given word = "ABCB", return false.
*/

//深度优先遍历
public class _079_WordSearch {
	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";
		boolean res = new _079_WordSearch().exist(board, word);
		System.out.println(res);
	}

	public boolean exist(char[][] board, String word) {
		char[] words = word.toCharArray();
		int row = board.length;
		int col = board[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				// 对于二维数组中的每一个字符，调用search方法。
				if (search(board, words, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean search(char[][] board, char[] words, int i, int j, int k) {
		if (k == words.length) {
			return true;
		}
		int row = board.length;
		int col = board[0].length;
		if (i < 0 || j < 0 || i >= row || j >= col || board[i][j] != words[k])
			return false;
		char temp = board[i][j];
		// 对于已经访问过的字符，我们使用$符号来代替。
		board[i][j] = '$';
		boolean res = search(board, words, i + 1, j, k + 1) || search(board, words, i - 1, j, k + 1)
				|| search(board, words, i, j + 1, k + 1) || search(board, words, i, j - 1, k + 1);
		board[i][j] = temp;
		return res;
	}
}
