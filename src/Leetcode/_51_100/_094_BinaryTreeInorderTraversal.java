package Leetcode._51_100;

import java.util.Arrays;
import java.util.Stack;

public class _094_BinaryTreeInorderTraversal {
	public static void main(String[] args) {
		System.out.println(JumpFloor(3));
	}
	public static int JumpFloor(int target) {
		int[] dp = new int[target];
        dp[0] = 1;
        if(target >1){
            dp[1] = 2;
            int i =2;
            while(i < target){
                int sum = 0;
                for(int j = 0;j < i;j++ ){
                    sum += dp[j];
                }
                dp[i] = sum;
                sum = 0;
                i++;
            }
        }
        return dp[target-1];
    }
}
