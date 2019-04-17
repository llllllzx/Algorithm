package Leetcode._1_50;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _003_2LSWR {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int n = s.length();
        int ans = 0;
          Map<Character,Integer> map = new HashMap<>();
          for(int j = 0,i=0;j<n;j++){
              if(map.containsKey(s.charAt(j))){
                  i = Math.max(map.get(s.charAt(j)),i);
              }
              ans = Math.max(ans,j - i + 1);
              map.put(s.charAt(j),j+1);
          }
          System.out.println(ans);
	}
}
