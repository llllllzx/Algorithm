package Leetcode._51_100;
/**
 * 如果我们知道其前面所有数字的乘积，同时也知道后面所有的数乘积，
 * 那么二者相乘就是我们要的结果，
 * 所以我们只要分别创建出这两个数组即可，
 * 分别从数组的两个方向遍历就可以分别创建出乘积累积数组
 * @author X6S
 *
 */
public class _238_ProductofArrayExceptSelf {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		int[] res = new _238_ProductofArrayExceptSelf().productExceptSelf(nums);
		for (int a : res) {
			System.out.println(a + " ");
		}
	}

	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		
		int[] leftArray = new int[n];
		int[] rightArray = new int[n];
		int[] res = new int[n];
		
		leftArray[0] = 1;
		rightArray[n - 1] = 1;
		
		//从左向右创建：乘积累积数组
		for (int i = 1; i < n; i++) {
			leftArray[i] = nums[i - 1] * leftArray[i - 1];
		}
		//从右向左创建：乘积累计视频。
		for (int i = n - 2; i >= 0; i--) {
			rightArray[i] = nums[i + 1] * rightArray[i + 1];
		}
		
		for (int i = 0; i < n; i++) {
			res[i] = leftArray[i] * rightArray[i];
		}
		
		return res;
	}
}
