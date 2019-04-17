package Leetcode._1_50;

import java.text.DecimalFormat;

public class _050_Pow {
	public static void main(String[] args) {
		double x = 2;
		int n = -1;
		double myPow = new _050_Pow().myPow(x, n);
		System.out.println(myPow);
	}

	public double myPow(double x, int n) {
		double sum = x;
		if (n == 0) {
			return 1.00000;
		}
		boolean flag = false;
		//	在求绝对值的时候，一定要考虑越界的问题。
		long pn = Math.abs((long) n);
		int sqrt = (int) Math.sqrt(pn);

		for (int i = 1; i < sqrt; i++) {
			sum *= x;
		}
		double t = sum;
		for (int i = 1; i < sqrt; i++) {
			t *= sum;
		}

		int a = (int) (pn - sqrt * sqrt);
		for (int i = 0; i < a; i++) {
			t *= x;
		}

		return n >= 1 ? t : 1 / t;
	}

	
	public double myPow1(double x, int m) {
		double temp = x;
		if (m == 0)
			return 1;
		temp = Math.pow(x, m / 2);
		if (m % 2 == 0)
			return temp * temp;
		else {
			if (m > 0)
				return x * temp * temp;
			else
				return (temp * temp) / x;
		}
	}
}
