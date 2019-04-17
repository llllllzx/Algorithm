package Leetcode._1_50;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
		Input:
		[4,2,0,2,3,2,0]
		Output:
		[4,2,2,0,0,2,3]
		Expected:
		[4,2,0,3,0,2,2]

 * @author X6S
 *
 *这个结果是错的。
 */
public class _031_0NextPermutation {
	public static void main(String[] args) {
		int[] nums = new int[] {2,3,1};
		nextPermutation(nums);
		for (int a : nums) {
			System.out.print(a + "\t");
		}
		// 输出2 1 3才行。
	}

	public static void nextPermutation(int[] nums) {
		boolean flag = false;
		int i = 0;
		int j = 0;
		for (i = nums.length - 1; i > 0; i--) {
			for (j = i - 1; j >= 0; j--) {
				if (nums[j] < nums[i]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
					flag = true;
					break;
				}
			}
			if (flag) {
				List<Integer> list = new ArrayList<>();
				for (int k = j + 1; k < nums.length; k++) {
					list.add(nums[k]);
				}
				Collections.sort(list);
				for (int k = j + 1; k < nums.length; k++) {
					nums[k] = list.get(k - j - 1);
				}
				break;
			}
			
		}

		if (!flag) {
			for (int n = 0, m = nums.length - 1; n < (nums.length / 2); n++, m--) {
				int tmp = nums[n];
				nums[n] = nums[m];
				nums[m] = tmp;
			}
		}
	}

}
