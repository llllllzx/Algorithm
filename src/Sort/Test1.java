package Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoxinliu on 2019/3/25
 */
public class Test1 {
    public static void main(String[] args) {
        int numRows = 2;
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            System.out.println(result);
        }
        List<Integer> beforeList = new ArrayList<>();
        if (numRows == 1) {
            beforeList.add(1);
            result.add(beforeList);
        }
        for (int i = 1; i < numRows; i++) {
            List<Integer> nextList = new ArrayList<>();
            nextList.add(1);
            for (int j = 1; j < i; j++) {
                int left = beforeList.get(j - 1);
                int right = beforeList.get(j);
                nextList.add(left + right);
            }
            nextList.add(1);
            result.add(nextList);
            beforeList = nextList;
        }
       System.out.println(result);
    }
}
