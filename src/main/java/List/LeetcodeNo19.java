package List;

/**
 * Created by chan
 * Date: 2019/6/7 10:58
 * Description:删除链表的倒数第N个节点
 */
public class LeetcodeNo19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        ListNode pre = dummy;
        int k = 0;
        // solution certainly exist
        while (k++ <= n ) {
            node = node.next;
        }
        //find last k node, remember last k+1 node
        //remove k node
        while (node != null) {
            node = node.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] a = {1, 2};
        ListNode head = ListNode.construct(a);
        ListNode result = new LeetcodeNo19().removeNthFromEnd(head, 2);
        ListNode.printList(result);
    }
}
