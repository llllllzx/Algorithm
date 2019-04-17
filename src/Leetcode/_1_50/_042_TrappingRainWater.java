package Leetcode._1_50;

public class _042_TrappingRainWater {
	public static void main(String[] args) {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int res = new _042_TrappingRainWater().trap(height);
		System.out.println(res);
	}

	public int trap(int[] height) {
		// 声明左右两个指针。
		int left = 0, right = height.length - 1;
		// 对左右指针进行剪枝优化。
		while (left < right && height[left] <= height[left + 1])
			left++;
		while (left < right && height[right - 1] >= height[right])
			right--;

		int totalWater = 0;
		// System.out.println(left + "===>" + right);
		while (left < right) {
			int leftVal = height[left];
			int rightVal = height[right];
			//右边界值大于等于左边界值的时候，确保计算的是有效值。（确保在循环的过程中右边一定会出现一个比左边大的值）。
			if (leftVal <= rightVal) {
				//从左边界开始一直累加，当有一个数字大于左边界值的时候，就停止循环。
				while (left < right && leftVal >= height[left]) {
					totalWater += leftVal - height[left];
					left++;
				}
			} else {
				while (left < right && height[right] <= rightVal) {
					totalWater += rightVal - height[right];
					right--;
				}
			}

		}
		return totalWater;
	}
}
