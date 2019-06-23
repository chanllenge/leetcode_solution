package tree;

/**
 * Created by chan
 * Date: 2019/6/23 18:21
 * Description:
 */
public class Leetcode236 {
    private TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recur(root, p, q);
        return result;
    }

    private boolean recur(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;

        int left = recur(node.left, p, q) ? 1 : 0;
        int right = recur(node.right, p, q) ? 1 : 0;
        int mid = node.val == p.val || node.val == q.val ? 1 : 0;

        if (left + right + mid >= 2) {
            result = node;
        }
        return left + right + mid > 0;
    }


    public static void main(String[] args) {
        Integer[] a = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode p = new TreeNode(5), q = new TreeNode(1);
        TreeNode root = TreeNode.constructTree(a);
        System.out.println(new Leetcode236().lowestCommonAncestor(root, p, q).val);
    }
}
