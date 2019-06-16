package list;

/**
 * Created by chan
 * Date: 2019/6/16 15:39
 * Description:
 */
public class Leetcode237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
