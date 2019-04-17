package Leetcode._1_50;

/**
 * 在leetcode上会超时。
 * 
 * @author X6S
 *
 */
public class _029_1DivideTwoIntegers {
	public static void main(String[] args) {
		int dividend = -1;
		int divisor = -1;
		int quotient = divide(dividend, divisor);
		System.out.println(quotient);
	}

	public static int divide(int dividend, int divisor) {
		final long max = new Long(Integer.MAX_VALUE);
		final int INT_MAX = Integer.MAX_VALUE;
		long m = Math.abs((long) dividend), n = Math.abs((long) divisor), res = 0;
		if (m < n)
			return 0;
		while (m >= n) {
			long t = n, p = 1;
			while (m > (t << 1)) {
				t <<= 1;
				p <<= 1;
			}
			res += p;
			m -= t;
		}
		if ((dividend < 0) ^ (divisor < 0)) res = -res;
        return res > max ? INT_MAX : (int)res;
	}
}
