package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chan
 * Date: 2019/6/23 19:48
 * Description:
 */
public class Leetcode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;
        int u = 0, d = matrix.length - 1, l = 0, r = matrix[0].length - 1;
        while (true) {
            for (int i = l; i <= r; i++) {
                list.add(matrix[u][i]);
            }
            if (++u > d) break;

            for (int i = u; i <= d; i++) {
                list.add(matrix[i][r]);
            }
            if (--r < l) break;

            for (int i = r; i >= l; i--) {
                list.add(matrix[d][i]);
            }
            if (--d < u) break;

            for (int i = d; i >= u; i--) {
                list.add(matrix[i][l]);
            }
            if (++l > r) break;
        }
        return list;
    }

    public static void main(String[] args) {
//        int[][] a = {   {1, 2, 3, 4},
//                        { 5, 6, 7, 8 },
//                        { 9, 10, 11, 12 }};
        int[][] a = {};
        System.out.println(new Leetcode54().spiralOrder(a));
    }
}
