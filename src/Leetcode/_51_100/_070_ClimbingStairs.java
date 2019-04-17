package Leetcode._51_100;

/**
 * 假设梯子有n层，那么如何爬到第n层呢，因为每次只能爬1或2步，
 * 那么爬到第n层的方法要么是从第n-1层一步上来的，要不就是从n-2层2步上来的，
 * 所以递推公式非常容易的就得出了：dp[n] = dp[n-1] + dp[n-2]
 * @author X6S
 *
 */
public class _070_ClimbingStairs {
	public static void main(String[] args) {
		_070_ClimbingStairs obj = new _070_ClimbingStairs();
		int res = obj.climbStairs1(3);
		System.out.println(res);
		int res2 = obj.climbStairs2(2);
		System.out.println(res2);
		int res3 = obj.climbStairs3(6);
		System.out.println(res3);
	}

	public int climbStairs1(int n) {
		if (n == 1) {
			return 1;
		}
		int[] nums = new int[n];
		nums[0] = 1;
		nums[1] = 2;
		for (int i = 2; i < n; i++) {
			nums[i] = nums[i - 1] + nums[i - 2];
		}
		return nums[n - 1];
	}

	public int climbStairs2(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int a = 1;
		int b = 2;
		int c = 0;
		for (int i = 2; i < n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}

	public int climbStairs3(int n) {
		return helper(n);
	}

	public int helper(int n) {
		if (n == 0) {
			return 0;
		}else if(n < 0) {
			return 0;
		}else if(n == 1) {
			return 1;
		}else if(n == 2) {
			return 2;
		}
		return helper(n - 1) + helper(n - 2);
	}
}
