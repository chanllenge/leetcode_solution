package list;

/**
 * Created by chan
 * Date: 2019/6/7 12:03
 * Description:删除链表中等于给定值 val 的所有节点。
 */
public class Leetcode203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] a = {1, 1};
        int value = 1;
        ListNode head = ListNode.construct(a);
        ListNode.printList(new Leetcode203().removeElements(head, value));
    }
}
