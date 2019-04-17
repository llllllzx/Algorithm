package Leetcode._51_100;

import java.util.ArrayList;
import java.util.List;
//	规律如下：
//	a1 = k / (n - 1)!
//	k1 = k
//	
//	a2 = k1 / (n - 2)!
//	k2 = k1 % (n - 2)!
//	...
//	
//	an-1 = kn-2 / 1!
//	kn-1 = kn-2 % 1!
//	
//	an = kn-1 / 0!
//	kn = kn-1 % 0!

public class _060_1PermutationSequence {
	public static void main(String[] args) {
		int n = 9, k = 2678;
		long start = System.currentTimeMillis();
		String res = new _060_1PermutationSequence().getPermutation(n, k);
		long end = System.currentTimeMillis();
		System.out.println(res + "耗时" + (end - start) + "毫秒");
	}

	public String getPermutation(int n, int k) {
		StringBuffer res = new StringBuffer();
		StringBuffer num = new StringBuffer("123456789");
		int[] f = new int[n];
		f[0] = 1;
		// f[0]中放0！f[1]中放1！.....f[n-1]放(n-1)!
		for (int i = 1; i < n; i++) {
			f[i] = f[i - 1] * i;
		}
		// 转化为数组下标。
		k--;
 
		for (int i = n; i >= 1; i--) {
			int j = k / f[i - 1];
			k %= f[i - 1];
			res.append(num.charAt(j));
			num = num.deleteCharAt(j);
		}
		return res.toString();
	}
}
