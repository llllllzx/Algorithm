package Leetcode._51_100;

import java.util.ArrayList;
import java.util.List;
//System.out.println("2^3运算的结果是 :"+(2^3));
//打印的结果是:   2^3运算的结果是 :1
//那么这个1是怎么来的,我们要知道^、<<、>>等位运算符主要针对二进制,
//算异或的时候相同的为0,不同的为1 
//2转换成二进制是0010 
//3转换成二进制是0011 
//所以0010^0011的结果就是0001转换成十进制是1 ,所以2^3=1
public class _089_GrayCode {
	public static void main(String[] args) {
		List<Integer> res = new _089_GrayCode().grayCode(3);
		System.out.println(res);
	}

	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < 1 << n; i++) {
			res.add(i ^ (i >> 1));
		}
		return res;
	}
}
