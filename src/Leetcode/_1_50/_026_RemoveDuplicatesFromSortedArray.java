package Leetcode._1_50;

public class _026_RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		int[] array = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int a = removeDuplicates(array);
		System.out.println(a);
		
		System.out.println("#################");
		for(int i = 0;i < array.length;i++) {
			System.out.print(array[i]+"\t");
		}
	}

	public static int removeDuplicates(int[] nums) {
		if (nums.length == 1) {
			return 1;
		}
		if (nums.length == 0) {
			return 0;
		}
		int count = 1;
		int tmp = nums[0];
		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != tmp) {
				index++;
				count++;
				nums[index] = nums[i];
				tmp = nums[i];
			}
		}
		return count;
	}
}
