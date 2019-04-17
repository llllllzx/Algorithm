package Leetcode._1_50;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
		'4' in row 7 is encoded as "(4)7".
		'4' in column 7 is encoded as "7(4)".
		'4' in the top-right block is encoded as "0(4)2".
		
		 if we ever fail to add something because it was already added
 * @author X6S
 *
 */
public class _036_0ValidSudoku {
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
		boolean b = isValidSudoku(sudo);
		System.out.println(b);
	}
	
	public static boolean isValidSudoku(char[][] board) {
		Set<String> set = new HashSet<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				char ch = board[i][j];
				if (ch != '.') {
					String str = "(" + ch + ")";
					if (!set.add(i + str) || !set.add(str + j) || !set.add(i / 3 + str + j / 3)) {
						return false;
					}
				}
			}
		}

		return true;
	}

	
}
