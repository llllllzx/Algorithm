package Leetcode._51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _090SubsetsII {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 2 };
		List<List<Integer>> res = new _090SubsetsII().subsetsWithDup(nums);
		System.out.println(res);
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		helper(nums, res, tempList, 0);
		return res;
	}

	private void helper(int[] nums, List<List<Integer>> res, List<Integer> tempList, int start) {
		res.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}
			int num = nums[i];
			tempList.add(num);
			helper(nums, res, tempList, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}
}
