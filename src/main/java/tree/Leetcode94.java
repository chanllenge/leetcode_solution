package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuyuanhe
 * Date: 19-6-24 上午8:13
 * Description:
 */
public class Leetcode94 {
    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        recur(root);
        return result;
    }

    private void recur(TreeNode node) {
        if (node == null) return;
        recur(node.left);
        result.add(node.val);
        recur(node.right);
    }

    public static void main(String[] args) {
        Integer[] a = {1,null,2,3};
        System.out.println(new Leetcode94().inorderTraversal(TreeNode.constructTree(a)));
    }
}
