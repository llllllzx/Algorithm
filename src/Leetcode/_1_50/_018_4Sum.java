package Leetcode._1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _018_4Sum {
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		List list = fourSum(nums, target);
		System.out.println(list);
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		Set<List<Integer>> set = new HashSet<>();
		List<List<Integer>> resList = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {
				//这个语句比较好。
				if (j > i + 1 && nums[j] == nums[j - 1])
					
					continue;
				int left = j + 1, right = nums.length - 1;
				while (left < right) {
					int sum = nums[i] + nums[j] + nums[left] + nums[right];
					if (sum == target) {
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[left]);
						list.add(nums[right]);

						set.add(list);
						left++;
						right--;
					} else if (sum < target) {
						left++;
					} else {
						right--;
					}

				}
			}
		}
		for (List<Integer> li : set) {
			resList.add(li);
		}
		return resList;
	}
}
