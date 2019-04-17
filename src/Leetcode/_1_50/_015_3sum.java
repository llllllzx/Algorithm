package Leetcode._1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 我们找出三个数且和为0，那么除了三个数全是0的情况之外，肯定会有负数和正数，
 * 我们还是要先fix一个数，然后去找另外两个数，我们只要找到两个数且和为第一个fix数的相反数就行了，
 * 既然另外两个数不能使用Two Sum的那种解法来找，
 * 如果能更有效的定位呢？我们肯定不希望遍历所有两个数的组合吧，
 * 所以如果数组是有序的，那么我们就可以用双指针以线性时间复杂度来遍历所有满足题意的两个数组合。
 * 
 * @author X6S
 *
 */
public class _015_3sum {
	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> res = new ArrayList<>();
		// 首先将数组进行排序
		Arrays.sort(nums);

		// 如果整个数组非空，且为负数的话，直接返回。
		if (nums.length > 0 && nums[nums.length - 1] < 0)
			return;
 
		for (int k = 0; k < nums.length; k++) {
			// 做个剪枝优化，如果要fix的数就是正数了，那么后面的数字就都是正数，永元不会出现和为0的情况了。
			if (nums[k] > 0)
				break;
			// 如果出现重复数字的话，直接跳过。
			if (k > 0 && nums[k] == nums[k - 1])
				continue;

			int i = k + 1;
			int j = nums.length - 1;
			int target = 0 - nums[k];
			while (i < j) {
				if (nums[i] + nums[j] == target) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[k]);
					list.add(nums[i]);
					list.add(nums[j]);
					res.add(list);
					// 出现重复数字的话，直接跳过。
					while (i < j && nums[i] == nums[i + 1])
						i++;
					while (i < j && nums[j] == nums[j - 1])
						j--;
					i++;
					j--;
				} else if (nums[i] + nums[j] < target) {
					i++;
				} else {
					j--;
				}
			}
		}
		System.out.println(res);
	}
}
