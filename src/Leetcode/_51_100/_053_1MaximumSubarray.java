package Leetcode._51_100;

import java.util.ArrayList;
import java.util.List;

public class _053_1MaximumSubarray {
	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int result = new _053_1MaximumSubarray().maxSubArray(nums);
		System.out.println(result);
	}

	public int maxSubArray(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int sum = nums[0];
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			//如果当前数字与sum的和比当前数字要小，说明之前的和为负数，故sum赋值为当前数字；
			//否则sum加上当前数字。
			if (nums[i] + sum < nums[i]) {
				sum = nums[i];
			} else {
				sum += nums[i];
			}
			
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}

}
