package Leetcode._1_50;
/**
			Symbol       Value
			I             1
			V             5
			X             10
			L             50
			C             100
			D             500
			M             1000
 * @author X6S
 *
 */
public class _012_IntegerToRoman {
	public static void main(String[] args) {
		int num = 1995;
		String str = intToRoman(num);
		System.out.println(str);
	}

	public static String intToRoman(int num) {
		String res = "";
		int[] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] str = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		return null;
	}
}
