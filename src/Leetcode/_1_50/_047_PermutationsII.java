package Leetcode._1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _047_PermutationsII {
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 2 };
		List<List<Integer>> permuteUnique = new _047_PermutationsII().permuteUnique(nums);
		System.out.println(permuteUnique);
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<Integer>(), nums, new boolean[nums.length]);
		return list;
	}

	private void backtrack(List<List<Integer>> list, ArrayList<Integer> tmpList, int[] nums, boolean[] used) {
		if (tmpList.size() == nums.length) {
			list.add(new ArrayList<>(tmpList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
					continue;
				used[i] = true;
				tmpList.add(nums[i]);
				backtrack(list, tmpList, nums, used);
				used[i] = false;
				tmpList.remove(tmpList.size() - 1);
			}
		}
	}
}
