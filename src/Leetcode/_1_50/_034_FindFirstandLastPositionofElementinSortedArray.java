package Leetcode._1_50;

import java.util.ArrayList;
import java.util.List;

public class _034_FindFirstandLastPositionofElementinSortedArray {
	public static void main(String[] args) {
		// int[] nums = new int[] { 5, 8, 7, 8, 8, 10 };
		int[] nums = new int[] {8,8,8,8,8,8};
		int target = 8;
		int[] res = searchRange(nums, target);
		for (int a : res) {
			System.out.print(a + " ");
		}
	}

	public static int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				list.add(i);
			}
		}
		if (!list.isEmpty()) {
			res[0] = list.get(0);
			res[1] = list.get(list.size() - 1);
			return res;
		}
		 res[0] = -1;
		 res[1] = -1;
		 return res;
	}
}
