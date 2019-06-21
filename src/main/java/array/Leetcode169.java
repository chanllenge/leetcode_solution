package array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by yuyuanhe
 * Date: 19-6-19 上午8:33
 * Description:求众数
 */
public class Leetcode169 {
    public int majorityElement(int[] nums) {
        int count = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (final int num : nums) {
            if (!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num) + 1);
        }
        List<Integer> list = map.entrySet().stream().filter(x-> x.getValue() > count).map(x->x.getKey()).collect(Collectors.toList());
        return list.get(0);
    }

    public static void main(String[] args) {
        int[] a= {3,2,3};
        System.out.println(new Leetcode169().majorityElement(a));

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "linode.com");
        map.put(2, "heroku.com");

        //Map -> Stream -> Filter -> String
        String result = map.entrySet().stream()
                .filter(x -> "something".equals(x.getValue()))
                .map(x->x.getValue())
                .collect(Collectors.joining());
    }
}
