package Leetcode._51_100;

import java.util.ArrayList;
import java.util.List;

public class _066_0PlusOne {
	public static void main(String[] args) {
		// int[] digits = { 1, 2, 3 };
		// int[] digits = { 0 };
		int[] digits = { 9 };
		int[] res = new _066_0PlusOne().plusOne(digits);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]);
		}
	}

	public int[] plusOne(int[] digits) {
		if (digits.length == 1 && digits[0] == 0) {
			return new int[] { 1 };
		}
		int r = digits[digits.length - 1] + 1;
		int carry = 0;
		carry = r / 10;
		if (carry == 0) {
			digits[digits.length - 1] = r;
			return digits;
		} else {
			digits[digits.length - 1] = 0;
			for (int i = digits.length - 2; i >= 0; i--) {
				int a = digits[i] + carry;
				carry = a / 10;
				if (carry == 0) {
					digits[i] = a;
					return digits;
				} else {
					digits[i] = 0;
					carry = 1;
				} 
			}
			
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			if (carry == 1) {
				System.arraycopy(digits, 0, res, 1, digits.length);
			}
			return res;
		}
	}
}
