package Leetcode._51_100;

import java.util.ArrayList;
import java.util.List;

public class _066_1PlusOne {
	public static void main(String[] args) {
		// int[] digits = { 1, 2, 3 };
		// int[] digits = { 0 };
		int[] digits = { 9 };
		int[] res = new _066_1PlusOne().plusOne(digits);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]);
		}
	}

	// public int[] plusOne(int[] digits) {
	// int index = digits.length - 1;
	// for (; index >= 0; index--) {
	// digits[index] = (digits[index] + 1) % 10;
	// // 只要是digits[index] == 0,就说明有了进位，再次进行for循环。
	// if (digits[index] != 0)
	// break;
	// ;
	// }
	// if (digits[0] == 0) {
	// int[] res = new int[digits.length + 1];
	// res[0] = 1;
	// return res;
	// }
	// return digits;
	// }

	public int[] plusOne(int[] digits) {
		int n = digits.length;
		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		int[] res = new int[n + 1];
		res[0] = 1;
		return res;
	}
}
