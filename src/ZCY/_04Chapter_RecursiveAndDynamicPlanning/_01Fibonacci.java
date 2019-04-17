package ZCY._04Chapter_RecursiveAndDynamicPlanning;

/**
 * Created by zhaoxinliu on 2019/4/8
 * 斐波那契数列的最优解。
 * (f(n),f(n-1)) = (f(n-1),f(n-2)) * {{1,1},{1,0}}
 *
 * (f(n),f(n-1)) = (1,1) * {{1,1},{1,0}}^n
 */
public class _01Fibonacci {
    public static void main(String[] args) {
        int result = new _01Fibonacci().f(6);
        System.out.println(result);
    }
    public int f(int n){
        if(n < 1){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        int[][] base = {{1,1,},{1,0}};
        int[][] res = matrixPower(base ,n -2);
        return res[0][0] + res[1][0];//第一列相加。
    }

    public  int[][] matrixPower(int[][] m, int p) {
        int [][] res = new int[m.length][m[0].length];
        for(int i = 0; i < res.length;i++){
            res[i][i] = 1;
        }
        int[][] temp = m;
        for(; p != 0 ; p >>= 1){
            if((p & 1) != 0){
                res = multiMatrix(res , temp);
            }
            temp = multiMatrix(temp,temp);
        }
        return res;
    }
    public int[][] multiMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }
}
