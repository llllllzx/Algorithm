package Leetcode._51_100;

public class _088_MergeSortedArray {
	public static void main(String[] args) {
		_088_MergeSortedArray girl = new _088_MergeSortedArray();
		int[] nums1 = { 0};
		int[] nums2 = { 1};
		int m = 0;
		int n = 1;
		girl.merge(nums1, m, nums2, n);
		for (int a : nums1) {
			System.out.print(a + " ");
		}
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1;
		int k = m + n - 1;
		while (i >= 0 && j >= 0) {
			nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
		}
		while (j >= 0) {
			nums1[k--] = nums2[j--];
		}
	}
}
