package Leetcode._1_50;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Input: [4,2,0,2,3,2,0] Output: [4,2,2,0,0,2,3] Expected: [4,2,0,3,0,2,2]
 * 
 * @author X6S
 *
 *         如果从末尾往前看，数字逐渐变大，到了2时才减小的，然后我们再从后往前找第一个比2大的数字，是3，那么我们交换2和3，再把此时3后面的所有数字转置一下即可
 *         1 ‘2’ 7 4 3 1
 * 
 *         1 ‘2’ 7 4 ‘3’ 1
 * 
 *         1 ‘3’ 7 4 ‘2’ 1
 * 
 *         1 3 ‘1 2 4 7’
 *
 */
public class _031_1NextPermutation2 {
	public static void main(String[] args) {
		// int[] nums = new int[] { 4, 2, 0, 2, 3, 2, 0 };
		// int[] nums = new int[] { 1, 3, 2 };
		// int[] nums = new int[] { 2,4,3,1};
		int[] nums = new int[] { 1, 2, 7, 4, 3, 1 };
		nextPermutation(nums);
		for (int a : nums) {
			System.out.print(a + "\t");
		}
		// 输出2 1 3才行。
	}

	public static void nextPermutation(int[] nums) {
		int i, j, len = nums.length;
		for (i = len - 2; i >= 0; i--) {
			// 找到开始减少的位置，在2时才开始减少的
			if (nums[i] < nums[i + 1]) {

				// 从后往前找到第一个比2大的数
				for (j = len - 1; j > i; j--) {
					if (nums[j] > nums[i])
						break;
				}
				// 交换2和3
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;

				// 将3后面的数字转置一下。
				for (int n = i + 1, m = nums.length - 1; n <= (nums.length + i) / 2; n++, m--) {
					int t = nums[n];
					nums[n] = nums[m];
					nums[m] = t;
				}
				return;
			}

		}
		// 如果一开始给的数组是降序，则直接转置。
		for (int n = 0, m = nums.length - 1; n < (nums.length / 2); n++, m--) {
			int tmp = nums[n];
			nums[n] = nums[m];
			nums[m] = tmp;
		}
	}

}
