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
 *
 */
public class _055_2JumpGame {
	public static void main(String[] args) {
		int[] nums = { 9, 0, 0, 0, 0, 0, 0, 0, 1, 0 };
		boolean canJump = new _055_2JumpGame().canJump(nums);
		System.out.println(canJump);
	}

	public boolean canJump(int[] nums) {
		int len = nums.length;
		if (len < 1) {
			return false;
		}
		int canReach = len - 1;
		for (int i = len - 2; i >= 0; i--) {
			if (nums[i] >= canReach - i) {
				canReach = i;
			}
		}
		return canReach == 0;
	}

}
