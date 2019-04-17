package Leetcode._51_100;

import java.util.ArrayList;
import java.util.List;

//	给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

//	
//	按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
//	
//	"123"
//	"132"
//	"213"
//	"231"
//	"312"
//	"321"
//	给定 n 和 k，返回第 k 个排列。

//	输入: n = 3, k = 3
//	输出: "213"
/**
 * 超时！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
 * @author X6S
 *
 */
public class _060_0PermutationSequence {
	public static void main(String[] args) {
		int n = 9, k = 2678;
		long start = System.currentTimeMillis();
		String res = new _060_0PermutationSequence().getPermutation(n, k);
		long end = System.currentTimeMillis();
		System.out.println(res +"耗时" +(end - start) +"毫秒");
	}

	public String getPermutation(int n, int k) {
		
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		helper(res, tempList, n);
		//System.out.println(res.size());
		List<Integer> list = res.get(k - 1);
		StringBuffer sb = new StringBuffer();
		for (Integer in : list) {
			sb.append(in + "");
		}
		return sb.toString();
	}

	private void helper(List<List<Integer>> res, List<Integer> tempList, int n) {
		if (tempList.size() == n) {
			res.add(new ArrayList<>(tempList));
		} else {
			for (int i = 1; i <= n; i++) {
				if (tempList.contains(i)) {
					continue;
				}
				tempList.add(i);
				helper(res, tempList, n);
				tempList.remove(tempList.size() - 1);
			}
		}

	}

}
