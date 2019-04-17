package Leetcode._51_100;

public class _080_1RemoveDuplicatesfromSortedArrayII_review {
	public static void main(String[] args) {
		int[] nums = { 0, 0,0, 1, 1, 1, 1, 2, 3, 3 };
		int len = new _080_1RemoveDuplicatesfromSortedArrayII_review().removeDuplicates(nums);
		for (int i = 0; i < len; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	public int removeDuplicates(int[] nums) {
		int i = 0;
		for (int n : nums)
			if (i < 2 || n > nums[i - 2])
				nums[i++] = n;
		return i;
	}
}
