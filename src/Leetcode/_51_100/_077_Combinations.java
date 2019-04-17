package Leetcode._51_100;

import java.util.ArrayList;
import java.util.List;

public class _077_Combinations {
	public static void main(String[] args) {
		int n = 4, k = 3;
		List<List<Integer>> result = new _077_Combinations().combine(n, k);
		System.out.println(result);
	}

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<>();
		if (n < k) {
			return list;
		}

		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}
		backtrack(list, new ArrayList<Integer>(), nums, 0, k);
		return list;
	}

	public void backtrack(List<List<Integer>> list, ArrayList<Integer> tempList, int nums[], int start, int k) {
		if (tempList.size() == k) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = start; i < nums.length; i++) {
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, i + 1, k);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
