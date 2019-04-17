package ZCY.Sort;

import java.util.Arrays;

/**
 * Created by zhaoxinliu on 2019/3/20
 */
public class Test {
    public static void main(String[] args) {
//        int[][] m1 = {{1,1},
//                      {2,2},
//                      {3,3}};
//        int[][] m2 = {{1,1},
//                      {2,2},};
//        int[][] res = multiMatrix(m1, m2);
//        for(int i= 0;i<res.length;i++){
//            for(int j =0;j < res[0].length;j++){
//                System.out.print(res[i][j] + " ");
//            }
//            System.out.println();
//        }
        double power = Power(2.0, -3);
        System.out.println(power);
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        ListNode next1 = null;
        ListNode next2 = null;
        while(l1 != null || l2 != null){
            if(l1.val > l2.val){
                next2 = l2.next;
                pre.next = l2;
                pre = pre.next;
                l2.next = null;
                l2 = next2;
            }else{
                next1 = l1.next;
                pre.next = l1;
                pre = pre.next;
                l1.next = null;
                l1 = next1;
            }
        }
        if(l1 != null){
            pre.next = l1;
        }
        if(l2 != null){
            pre.next = l2;
        }
        return head.next;
    }
    public static int[][] multiMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m2[0].length; i++) {
            for (int j = 0; j < m1.length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[j][i] += m1[j][k] * m2[k][i];
                }
            }
        }
        return res;
    }

    public static double Power(double base, int exponent) {
        double res = 1.0d;
        double temp = base;
        for(; exponent != 0; exponent >>= 1){
            if((exponent & 1) != 0){
                res = res * temp;
            }
            temp *= temp;
        }
        return res;
    }
}



class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
}