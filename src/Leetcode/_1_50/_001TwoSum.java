package Leetcode._1_50;

import java.util.Scanner;

/**
 * 
 * @author X6S
input: 6
	   2 7 2 7 11 15
	   9
	   
output:[0,1] [0,3] [1,2] [2,3] 
 */
public class _001TwoSum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}
		int[] result;
		int target = in.nextInt();
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result = new int[] { i, j };
					System.out.print("[" + result[0] + "," + result[1] + "] ");
				}
			}
		}
	}
}
