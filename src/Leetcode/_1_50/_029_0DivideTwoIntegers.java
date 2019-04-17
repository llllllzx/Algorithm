package Leetcode._1_50;
/**
 * 在leetcode上会超时。
 * @author X6S
 *
 */
public class _029_0DivideTwoIntegers {
	public static void main(String[] args) {
		int dividend = -1;
		int divisor = -1;
		int quotient = divide(dividend, divisor);
		System.out.println(quotient);
	}

	public static int divide(int dividend, int divisor) {
		final int INT_MIN = Integer.MIN_VALUE;
		final int INT_MAX = Integer.MAX_VALUE;
		if (dividend == INT_MIN && divisor == -1)
			return INT_MAX;
		// int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

		long a = 0;
		long b = 0;
		boolean flag = false;
		if (dividend < 0 && divisor > 0) {
			flag = true;
		} else if (dividend > 0 && divisor < 0) {
			flag = true;
		}
		a = Math.abs((long) dividend);
		b = Math.abs((long) divisor);
		int i = 0;
		int j = 0;
		while (true) {
			j = i * i;
			if ((a - b * j) > 0)
				i++;
			else
				break;
		}
		int k = 0;
		for (k = (i - 1) * (i - 1); k < i * i + 1; k++) {
			if ((a - b * k) < 0) {
				break;
			}
		}
		k = k - 1;
		return flag == true ? -k : k;
	}
}
