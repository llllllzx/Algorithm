package Leetcode._51_100;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestofRecursion {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		int res = getSum(nums, 0);
		int max = getMax(nums, 0, nums.length - 1);
		System.out.println("求和:" + res);
		System.out.println("求最大值:" + max);

		List<List<Integer>> res1 = new ArrayList<>();
		List<Integer> tempList1 = new ArrayList<>();
		getPermu1(nums, res1, tempList1);
		System.out.println(res1);

		List<List<Integer>> res2 = new ArrayList<>();
		List<Integer> tempList2 = new ArrayList<>();
		int[] arr = { 2, 1, 2 };
		Arrays.sort(arr);
		getPermu2(arr, res2, tempList2, new boolean[arr.length]);// 布尔数组中默认初始化为false
		System.out.println(res2);

	}

	/**
	 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
	 * @param nums
	 * @param res2
	 * @param tempList2
	 *  Input: [1,1,2]
		Output:
		[
		  [1,1,2],
		  [1,2,1],
		  [2,1,1]
		]
	 */
	private static void getPermu2(int[] nums, List<List<Integer>> res2, List<Integer> tempList2, boolean[] used) {
		if (tempList2.size() == nums.length) {
			res2.add(new ArrayList<>(tempList2));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
					continue;
				}
				used[i] = true;
				tempList2.add(nums[i]);
				getPermu2(nums, res2, tempList2, used);
				used[i] = false;
				tempList2.remove(tempList2.size() - 1);
			}
		}
	}

	/**
	 * 获得不同数字的排列数。
	 * @param nums
	 * @param res1
	 * @param tempList1
	 */
	private static void getPermu1(int[] nums, List<List<Integer>> res1, List<Integer> tempList1) {
		if (tempList1.size() == nums.length) {
			res1.add(new ArrayList<>(tempList1));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList1.contains(nums[i])) {
					continue;
				}
				tempList1.add(nums[i]);
				getPermu1(nums, res1, tempList1);
				tempList1.remove(tempList1.size() - 1);
			}
		}
	}

	/**
	 * 求最大值
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 */
	private static int getMax(int[] nums, int left, int right) {
		if (left == right) {
			return nums[left];
		}
		int mid = (left + right) / 2;
		int a = getMax(nums, left, mid);
		int b = getMax(nums, mid + 1, right);
		return Math.max(a, b);
	}

	/**
	 * 求和
	 * @param nums
	 * @param start
	 * @return
	 */
	private static int getSum(int[] nums, int start) {
		if (start == nums.length - 1) {
			return nums[start];
		}
		return nums[start] + getSum(nums, start + 1);
	}
}
