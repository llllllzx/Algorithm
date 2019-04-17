package Leetcode._1_50;

public class _011_1_ContainerWithMostWater2 {
	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int res = maxArea(height);
		System.out.println(res);
	}

	public static int maxArea(int[] height) {
		int i = 0, j = height.length - 1, maxArea = 0;
		while (i < j) {
			maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
			if (height[i] < height[j])
				i++;
			else
				j--;
		}
		return maxArea;
	}
}
