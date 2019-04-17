package Leetcode._51_100;

public class _069_Sqrt {
	public static void main(String[] args) {
		int res = new _069_Sqrt().mySqrt(4);
		System.out.println(res);
	}

	public int mySqrt(int x) {
		int res = (int) Math.sqrt(x);
		return res;
	}
}
