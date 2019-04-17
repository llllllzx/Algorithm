package Leetcode._1_50;

public class _027_1RemoveElement {
	public static void main(String[] args) {
		int[] nums = new int[] { 0, 1, 2, 2, 3, 0, 4, 2 };
		// int[] nums = new int[] { 1 };

		int len = removeElement(nums, 2);
		System.out.println(len);
	}

	public static int removeElement(int[] nums, int val) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val)
				nums[index++] = nums[i];
		}
		return index;
	}
}
