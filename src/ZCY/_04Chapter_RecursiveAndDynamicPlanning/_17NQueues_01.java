package ZCY._04Chapter_RecursiveAndDynamicPlanning;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoxinliu on 2019/4/7
 * <p>
 * Leetcode中的原题，要求最后的输出格式如下所示：
 * Input: 4
 * Output: [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 */
public class _17NQueues_01 {
    public static void main(String[] args) {
        _17NQueues_01 obj = new _17NQueues_01();
        List<List<String>> lists = obj.solveNQueens(8);
        System.out.println(lists.size());
        System.out.println(lists);
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        helper(chess, 0, res);
        return res;
    }

    public void helper(char[][] chess, int row, List<List<String>> res) {
        if (row == chess.length) {
            res.add(construct(chess));
            return;
        } else {
            char[][] chessTemp = chess.clone();

            for (int i = 0; i < chess.length; i++) {
                for (int j = 0; j < chess.length; j++) {
                    chessTemp[row][j] = '.';
                }
                chessTemp[row][i] = 'Q';
                if (isValid(chessTemp, row, i)) {
                    helper(chess, row + 1, res);
                }
            }
        }
    }

    public boolean isValid(char[][] chess, int row, int col) {
        int step = 1;
        while (row - step >= 0) {
            if (chess[row - step][col] == 'Q') {
                return false;
            }
            if (col - step >= 0 && chess[row - step][col - step] == 'Q') {
                return false;
            }
            if (col + step < chess.length && chess[row - step][col + step] == 'Q') {
                return false;
            }
            step++;
        }
        return true;
    }

    public List<String> construct(char[][] chess) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            String s = new String(chess[i]);
            res.add(s);
        }
        return res;
    }
}
