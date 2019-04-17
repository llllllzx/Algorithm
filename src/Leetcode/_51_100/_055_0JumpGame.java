package Leetcode._51_100;

/**
 * 
	 给定一个非负整数数组，你最初位于数组的第一个位置。
	数组中的每个元素代表你在该位置可以跳跃的最大长度。
	判断你是否能够到达最后一个位置。
	
	示例 1:
	输入: [2,3,1,1,4]
	输出: true
	解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * @author X6S
 *
 *
 *超时！！！！！！！！！！！！！！！！！！！
 */
public class _055_0JumpGame {
	public static void main(String[] args) {
		// int[] nums = { 2, 3, 1, 1, 4 };
		// int[] nums = { 3, 2, 1, 0, 4 };
		// int[] nums = { 2,3, 0,4 };
		// int[] nums = { 1, 1, 0, 1 };
		int[] nums = { 2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 };
		// int[] nums = {2,0,1};
		boolean canJump = new _055_0JumpGame().canJump(nums);
		System.out.println(canJump);
	}

	public boolean canJump(int[] nums) {
		int n = nums.length;
		boolean flag = helper(nums, n, 0);
		return flag;
	}

	private boolean helper(int[] nums, int n, int start) {
		// 终止条件
		if (n == 0) {
			return true;
		} else if (n < 0) {
			return false;
		}

		for (int i = start; i < nums.length; i++) {
			int num = nums[i];
			if (num == 0 && nums.length == start + 1) {
				return true;
			} else if (num == 0) {
				return false;
			}
			for (int j = 1; j <= num; j++) {
				int remain = nums.length - j - 1;
				boolean flag = helper(nums, remain, start + j);
				if (flag) {
					return true;
				}
			}
		}
		return true;
	}
}
