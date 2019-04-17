package Leetcode._1_50;

public class _007_ReverseInteger {
	public static final int INT_MAX = Integer.MAX_VALUE;
	public static void main(String[] args) {
		long a = reverse(-123);
		System.out.println(a);
	}

	public static int reverse(int x) {
		long res = 0;
		boolean isPositiv = true;
		if(x < 0) {
			isPositiv = false;
			x *= -1;
		}
		/**
		 *   %是取低位
		 *   /= 是干掉低位
		 */
		 
		while(x > 0) {
			res = res*10 + x % 10;
			 x /= 10;
		}
		
		if(res > INT_MAX) return 0;
		if(isPositiv) {
			return (int)res;
		}else {
			return (int)-res;
		}
	}
}
