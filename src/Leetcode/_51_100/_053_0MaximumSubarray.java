package Leetcode._51_100;

import java.util.ArrayList;
import java.util.List;
/**
 * 超时！！！！！！！！！！！！！！！！！！！！！
 * @author X6S
 *
 */
public class _053_0MaximumSubarray {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		int result = new _053_0MaximumSubarray().maxSubArray(nums);
		System.out.println(result);
	}

	public int maxSubArray(int[] nums) {
		int length = nums.length;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < length; i++) {

			for (int j = 0; j < length; j++) {
				int t = j;
				int k = j + i;
				while (j <= k && j < length) {
					sum += nums[j];
					j++;
				}
				if (sum > max) {
					max = sum;
				}
				sum = 0;
				j = t;
			}

		}
		return max;
	}

}
