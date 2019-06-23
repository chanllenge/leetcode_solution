package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chan
 * Date: 2019/6/23 20:24
 * Description: 螺旋矩阵II
 */
public class Leetcode59 {
    public int[][] generateMatrix(int n) {
        int number = n * n;
        int[][] result = new int[n][n];
        int j = 1;
        int l = 0, u = 0, d = n - 1, r = n - 1;
        while (true) {
            for (int i = l; i <= r; i++) {
                result[u][i] = j++;
            }
            if (++u > d || j > number) break;

            for (int i = u; i <= d; i++) {
                result[i][r] = j++;
            }
            if (--r < l || j > number) break;

            for (int i = r; i >= l; i--) {
                result[d][i] = j++;
            }
            if (--d < u || j > number) break;

            for (int i = d; i >= u; i--) {
                result[i][l] = j++;
            }
            if (++l > r || j > number) break;
        }
        return result;
    }

    public static void main(String[] args) {
        new Leetcode59().generateMatrix(4);
    }
}
