package List;

/**
 * Created by chan
 * Date: 2019/6/7 11:56
 * Description: 反转链表
 */
public class Leetcode206 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        ListNode head = ListNode.construct(a);
        ListNode.printList(new Leetcode206().reverseList(head));
    }
}
