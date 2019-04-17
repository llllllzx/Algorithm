package Leetcode._51_100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _073_0SetMatrixZeroes {
	public static void main(String[] args) {
		// int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		setZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void setZeroes(int[][] matrix) {
		//Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					String row = "(" + i + ")";
					String column = "[" + j + "]";
					list.add(row);
					list.add(column);
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				boolean a = list.contains("(" + i + ")");
				boolean b = list.contains("[" + j + "]");
				if (a || b) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
