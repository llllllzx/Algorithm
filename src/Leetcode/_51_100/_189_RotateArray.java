package Leetcode._51_100;

public class _189_RotateArray {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int k = 3+9;
		new _189_RotateArray().rotate(nums, k);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	public void rotate(int[] nums, int k) {
		int len = nums.length;
		int n = k % len;

		reverse(nums, 0, len - n - 1);
		reverse(nums, len - n, len-1);
		reverse(nums, 0, len-1);
	}

	private void reverse(int[] nums, int n, int m) {
		for (int i = n, j = m; i <= j; i++, j--) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}

}
