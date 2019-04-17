package Leetcode._1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _040_CombinationSumII {
	public static void main(String[] args) {
		int[] nums = new int[] { 10, 1, 2, 7, 6, 1, 5 };
		List<List<Integer>> result = new _040_CombinationSumII().combinationSum2(nums, 8);
		System.out.println(result);
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
		return list;
	}

	public void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
		if (remain < 0)
			return;
		else if (remain == 0)
			list.add(new ArrayList<>(tempList));
		else {
			for (int i = start; i < nums.length; i++) {
				//跳过重复的数字。
				if (i > start && nums[i] == nums[i - 1])
					continue;
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, remain - nums[i], i + 1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
