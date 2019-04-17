package Leetcode._1_50;

public class _011_0_ContainerWithMostWater {
	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int res = maxArea(height);
		System.out.println(res);
	}

	public static int maxArea(int[] height) {
		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int h = Math.min(height[i], height[j]);
				int w = j - i;
				if(h * w > maxArea) {
					maxArea = h * w;
				}
			}
		}
		return maxArea;
	}
}
