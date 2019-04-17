package Leetcode._1_50;

public class _009_0_PalindromeNumber {
	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
	}

	public static boolean isPalindrome(int x) {
		if(x < 0 || (x % 10 ==0 && x != 0)) {
			return false;
		}
		
		return reverse(x)==x;
	}
	public static int reverse(int x) {
		int INT_MAX = Integer.MAX_VALUE;
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
