package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chan
 * Date: 2019/6/23 18:40
 * Description:二叉搜索树中第K小的元素
 */
public class Leetcode230 {
    List<Integer> result = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        midOrder(root);
        return result.get(k-1);
    }

    private void midOrder(TreeNode root) {
        if (root != null) {
            midOrder(root.left);
            result.add(root.val);
            midOrder(root.right);
        }
    }

    public static void main(String[] args) {
        Integer[] a = {5,3,6,2,4,null,null,1};
        System.out.println(new Leetcode230().kthSmallest(TreeNode.constructTree(a), 3));
    }


}
