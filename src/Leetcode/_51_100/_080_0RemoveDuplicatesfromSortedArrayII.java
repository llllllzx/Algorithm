package Leetcode._51_100;

public class _080_0RemoveDuplicatesfromSortedArrayII {
	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
		int len = new _080_0RemoveDuplicatesfromSortedArrayII().removeDuplicates(nums);
		for (int i = 0; i < len; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		int temp = nums[0];
		int count = 0;
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			// 当相等的时候
			if (temp == nums[i]) {
				count++;
				// 如果数量少于两个，则进行填充。最后进行index++
				if (count <= 2) {
					nums[index] = nums[i];
					index++;
				}
			} else {// 如果不相等的时候，将count置为1,然后进行填充。最后index++
				count = 1;
				temp = nums[i];
				nums[index] = nums[i];
				index++;
			}
		}
		return index;
	}
}
