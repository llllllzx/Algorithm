package Leetcode._1_50;

public class _041_1FirstMissingPositive {
	public static void main(String[] args) {
		int[] nums = {1,2,2};
		int result = new _041_1FirstMissingPositive().firstMissingPositive(nums);
		System.out.println(result);
	}

	public int firstMissingPositive(int[] nums) {
		int n = nums.length;
		//使用n+1来代替  “非正数”  和 “大于n” 的数
		for (int i = 0; i < n; i++) {
			if (nums[i] <= 0 || nums[i] > n) {
				nums[i] = n + 1;
			}
		}
		//此时所有的数的范围在[1,n+1]
		
		//对数组中的数字进行标记。
		for (int i = 0; i < n; i++) {
			int num = Math.abs(nums[i]);
			if (num > n) {
				continue;
			}
			
			num--;
			
			//防止双重否定操作。
			if (nums[num] > 0) {
				nums[num] = -1 * nums[num];
			}
		}
		
		//
		for (int i = 0; i < n; i++) {
			if (nums[i] > 0) {
				return i + 1;
			}
		}
		return n + 1;
	}
}
