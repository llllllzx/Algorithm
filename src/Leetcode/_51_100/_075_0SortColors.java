package Leetcode._51_100;

import java.util.Arrays;

public class _075_0SortColors {
	public static void main(String[] args) {
		int[] nums = { 2, 0, 2, 1, 1, 1, 0, 2 };
		new _075_0SortColors().sortColors(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	public void sortColors(int[] nums) {
		// 分别记录0,1,2的个数。
		int aCount = 0;
		int bCount = 0;
		int cCount = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				aCount++;
			} else if (nums[i] == 1) {
				bCount++;
			} else {
				cCount++;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (i < aCount) {
				nums[i] = 0;
			} else if (i < aCount + bCount) {
				nums[i] = 1;
			} else {
				nums[i] = 2;
			}
		}
	}
}
