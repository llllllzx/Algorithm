package Leetcode._1_50;

public class _045_JumpGameII {
	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };
		int res = new _045_JumpGameII().jump(nums);
		System.out.println(res);
	}

	public int jump(int[] nums) {
		if (nums == null || nums.length < 2)
			return 0;
		// 记录返回结果
		int res = 0;
		// 当前能走的最大步数
		int curMaxArea = 0;
		// 最终能走的最大步数。
		int maxNext = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			maxNext = Math.max(maxNext, i + nums[i]);
			if (i == curMaxArea) {
				res++;
				curMaxArea = maxNext;
			}
		}
		return res;
	}
}
