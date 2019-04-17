package Leetcode._51_100;

import java.util.Arrays;

public class _075_1SortColors_review {
	public static void main(String[] args) {
		int[] nums = { 1, 0, 2, 1, 2, 1, 0, 2 };
		new _075_1SortColors_review().sortColors(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	public void sortColors(int[] nums) {
		int left = 0, right = nums.length - 1;
		for (int i = 0; i <= right; i++) {
			if (nums[i] == 0) {
				int temp = nums[i];
				nums[i] = nums[left];
				nums[left] = temp;
				left++;
			} else if (nums[i] == 2) {
				int temp = nums[i];
				nums[i] = nums[right];
				nums[right] = temp;
				i--;
				right--;
			}
		}
	}
}
