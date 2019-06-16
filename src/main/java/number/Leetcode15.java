package number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chan
 * Date: 2019/6/15 19:37
 * Description:
 */
public class Leetcode15 {
    /**
     * 提交多次还是有错...，最终逃脱不了超时的命运....
//     * @param nums
     * @return
     */
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                int target = -(nums[i] + nums[j]);
//                if (map.containsKey(target) && map.get(target) != i && map.get(target) != j) {
//                    List<Integer> temp = Arrays.asList(nums[i], target, nums[j]);
//                    if (list.size() == 0) {
//                        list.add(Arrays.asList(nums[i], target, nums[j]));
//                    } else {
//                        boolean have = false;
//                        for (List<Integer> a : list) {
//                            if(temp.contains(a.get(0)) && temp.contains(a.get(1)) && temp.contains(a.get(2))) {
//                                have = true;
//                                break;
//                            }
//                        }
//                        if (!have) list.add(Arrays.asList(nums[i], target, nums[j]));
//                    }
//                } else {
//                    if (!map.containsKey(nums[i])) map.put(nums[i], i);
//                    if (!map.containsKey(nums[j])) map.put(nums[j], j);
//                }
//            }
//        }
//        return list;
//    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int l = i + 1, r = nums.length - 1, sum = -nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l+1]) l++;
                        while (l < r && nums[r] == nums[r-1]) r--;
                        l++;r--;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l+1]) l++;
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r-1]) r--;
                        r--;
                    }
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        //-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0
        //1,2,-2,-1
        //2,2,-1,-3,3,1,-2,1,-2,3,0,-5,0,4,-3,3
        //3,0,3,2,-4,0,-3,2,2,0,-1,-5
        int[] array = {3,0,3,2,-4,0,-3,2,2,0,-1,-5};
        System.out.println(new Leetcode15().threeSum(array));
    }
}
