package Leetcode._1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 像这种结果要求返回所有符合要求解的题十有八九都是要利用到递归，而且解题的思路都大同小异。
 * 
 * @author X6S
 *
 */
public class _039_0CombinationSum {
	// boolean flag = false;

	public static void main(String[] args) {
		int[] candidates = new int[] { 2, 3, 5 };
		List<List<Integer>> li = new _039_0CombinationSum().combinationSum(candidates, 8);
		System.out.println(li);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
		return list;
	}

	public void backtrack(List<List<Integer>> list, List<Integer> tmpList, int[] nums, int remain, int start) {
		if (remain < 0) {
			return;
		} else if (remain == 0) {
			// list.add(tmpList);最后的输出结果为null。所以在这里重新new一个list.
			list.add(new ArrayList<>(tmpList));
		} else {
			for (int i = start; i < nums.length; i++) {
				tmpList.add(nums[i]);
				// star为i并不是i+1,因为我们可以重复使用相同的元素。
				backtrack(list, tmpList, nums, remain - nums[i], i);
				tmpList.remove(tmpList.size() - 1);
			}
		}
	}
}
