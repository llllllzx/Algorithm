package Leetcode._1_50;

public class _027_0RemoveElement {
	public static void main(String[] args) {
		int[] nums = new int[] { 0, 1, 2, 2, 3, 0, 4, 2 };
		// int[] nums = new int[] { 1 };

		int len = removeElement(nums, 1);
		System.out.println(len);
	}

	public static int removeElement(int[] nums, int val) {
		if (nums.length == 0) {
			return 0;
		}
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {
				continue;
			} else {
				nums[index++] = nums[i];
			}
		}
		// 如果index是0的话，就说明数组为{a,a,a,a,a,a,a}且val=a.
		return index == 0 ? 0 : index++;
	}
}
