package number;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chan
 * Date: 2019/6/22 18:39
 * Description:
 */
public class Leetcode89 {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < n; i++) {
            int add = 1 << i;
            for (int j = list.size() - 1; j >= 0 ; j--) {
                list.add(list.get(j) + add);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode89().grayCode(0));
        System.out.println(new Leetcode89().grayCode(1));
        System.out.println(new Leetcode89().grayCode(2));
        System.out.println(new Leetcode89().grayCode(3));
    }
}
