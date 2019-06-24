package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chan
 * Date: 2019/6/22 12:15
 * Description:
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }

    /**
     * 参考https://blog.csdn.net/my_learning_road/article/details/79580926
     * @param a
     * @return
     */
    public static TreeNode constructTree(Integer[] a) {
        List<TreeNode> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null) {
                list.add(null);
            } else {
                list.add(new TreeNode(a[i]));
            }
        }
        //按照索引位置构建二叉树
        for (int parentIndex = 0; parentIndex < a.length / 2 - 1; parentIndex++) {
            list.get(parentIndex).left = list.get(parentIndex * 2 + 1);
            list.get(parentIndex).right = list.get(parentIndex * 2 + 2);
        }
        //处理最后一个节点的情况
        int lastParentIndex = a.length / 2 - 1;
        if (list.get(lastParentIndex) != null) {
            list.get(lastParentIndex).left = list.get(lastParentIndex * 2 + 1);
            if (a.length % 2 == 1) {
                list.get(lastParentIndex).right = list.get(lastParentIndex * 2 + 2);
            }
        }
        return list.get(0);
    }

    public static void orderPrint(TreeNode node, Order order) {
        if (node != null) {
            if (order == Order.pre) {
                System.out.println(node.val);
                orderPrint(node.left, order);
                orderPrint(node.right, order);
            } else if (order == Order.mid) {
                orderPrint(node.left, order);
                System.out.println(node.val);
                orderPrint(node.right, order);
            } else if (order == Order.post) {
                orderPrint(node.left, order);
                orderPrint(node.right, order);
                System.out.println(node.val);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {-10,9,20,null,null,15,7};
        orderPrint(constructTree(a), Order.pre);
    }
}
