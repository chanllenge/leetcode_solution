package tree;

/**
 * Created by chan
 * Date: 2019/6/23 17:06
 * Description:二叉搜索树的最近公共祖先
 */
public class Leetcode235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        TreeNode node = root;
        while (true) {
            if (node.val >= p.val && node.val <= q.val) {
                return node;
            } else if (node.val < p.val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {6,2,8,0,4,7,9,null,null,3,5};
        TreeNode p = new TreeNode(2), q = new TreeNode(4);
        TreeNode root = TreeNode.constructTree(a);
        System.out.println(new Leetcode235().lowestCommonAncestor(root, p, q).val);
    }
}
