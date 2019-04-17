package Leetcode._1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: [1,2,3]
 * 
 * Output: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 * 
 * @author X6S
 *
 */
public class _046_0Permutations {
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3 };
		List<List<Integer>> list = new _046_0Permutations().permute(nums);
		System.out.println(list);
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<Integer>(), nums);
		return list;
	}

	public void backtrack(List<List<Integer>> list, List<Integer> tmpList, int[] nums) {
		if (tmpList.size() == nums.length) {
			list.add(new ArrayList<>(tmpList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				// 如果tmpList中已经包含了该数字，则直接跳过。
				if (tmpList.contains(nums[i]))
					continue;
				// 找不相同的数字加入tmpList
				tmpList.add(nums[i]);
				backtrack(list, tmpList, nums);
				tmpList.remove(tmpList.size() - 1);
			}
		}
	}

}
