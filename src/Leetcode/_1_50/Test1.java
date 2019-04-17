package Leetcode._1_50;

public class Test1 {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 3, 9, 5, 7, 8, 2, 4 };
		int a = new Test1().getMax(array, 0, array.length - 1);
		System.out.println(a);
	}

	public int getMax(int[] nums, int left, int right) {
		if (left == right) {
			return nums[left];
		}
		int mid = (left + right) / 2;
		int a = getMax(nums, left, mid);
		int b = getMax(nums, mid + 1, right);
		return Math.max(a, b);
	}
}
