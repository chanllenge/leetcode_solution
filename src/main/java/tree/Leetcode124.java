package tree;

/**
 * Created by chan
 * Date: 2019/6/23 16:47
 * Description:二叉树中的最大路径和
 */
public class Leetcode124 {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }

    private int maxGain(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(maxGain(root.left), 0);  //如果左子树的和小于0，则取0
        int right = Math.max(maxGain(root.right), 0);  //如果右子树的和小于0，则取0

        max = Math.max(root.val + left +right, max);
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        Integer[] a = {-10,9,20,null,null,15,7};
        TreeNode node = TreeNode.constructTree(a);
//        TreeNode.orderPrint(node, Order.pre);
        System.out.println(new Leetcode124().maxPathSum(TreeNode.constructTree(a)));
    }
}
