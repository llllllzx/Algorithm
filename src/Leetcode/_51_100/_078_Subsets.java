package Leetcode._51_100;

import java.util.ArrayList;
import java.util.List;

/*	Input: nums = [1,2,3]
	Output:
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
*/
public class _078_Subsets {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> res = new _078_Subsets().subsets(nums);
		System.out.println(res);
		// [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]

	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		helper(nums, res, tempList, 0);
		return res;
	}

	private void helper(int[] nums, List<List<Integer>> res, List<Integer> tempList, int start) {
		res.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			int num = nums[i];
			tempList.add(num);
			helper(nums, res, tempList, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}
}
