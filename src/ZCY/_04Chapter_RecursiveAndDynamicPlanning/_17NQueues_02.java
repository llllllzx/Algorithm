package ZCY._04Chapter_RecursiveAndDynamicPlanning;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaoxinliu on 2019/4/7
 * 只求有多少种解法
 */
public class _17NQueues_02 {
    public static void main(String[] args) {
        int res = new _17NQueues_02().num(8);
        System.out.println(res);
    }

    public int num(int n) {
        if (n < 1) {
            return 0;
        }
        int[] records = new int[n];
        return helper(0, records, n);
    }

    public int helper(int i, int[] records, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            records[i] = j;
            if (isValid(records, i, j)) {
                res += helper(i + 1, records, n);
            }
        }
        return res;
    }

    public boolean isValid(int[] records, int i, int j) {
        for (int k = 0; k < i; k++) {

            if (j == records[k] || Math.abs(k - i) == Math.abs(records[k] - j)) {
                return false;
            }
        }
        return true;
    }
}
