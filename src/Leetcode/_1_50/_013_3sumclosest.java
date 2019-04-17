package Leetcode._1_50;

import java.util.Arrays;
/**
 * 这道题在3sum的基础上又增加了一些难度。
 * @author X6S
 *
 */
public class _013_3sumclosest {
	public static void main(String[] args) {
		int[] nums = new int[] { -1, 2, 1, -4 };
		int res = threeSumClosest(nums, 1);
		System.out.println(res);
	}

	public static int threeSumClosest(int[] nums, int target) {
		if (nums.length < 3 || nums == null)
			return 0;
		//首先假设这三个数字是最近的。
		int closest = nums[0] + nums[1] + nums[2];
		//然后计算与target之间的距离。
		int diff = Math.abs(closest - target);
		//对数组进行排序。
		Arrays.sort(nums);
		/**
		 * 都是先确定一个数，然后用两个指针left和right来滑动寻找另外两个数，
		 * 每确定两个数，我们求出此三数之和，然后算和给定值的差的绝对值存在newDiff中，
		 * 然后和diff比较并更新diff和结果closest即可。
		 */
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				int newDiff = Math.abs(sum - target);
				if (diff > newDiff) {
					diff = newDiff;
					closest = sum;
				}
				if(sum < target) left++;
				else right--;
			}
		}
		return closest;
	}
}
