package list;

/**
 * Created by chan
 * Date: 2019/6/22 9:49
 * Description:旋转链表
 */
public class Leetcode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp= temp.next;
            len++;
        }
        int moved = len - (k >= len ? k % len : k);
        if (moved == len) return head;
        ListNode rotate = head;
        ListNode pre = null;
        while (moved-- > 0) {
            pre = rotate;
            rotate = rotate.next;
        }
        if (pre != null) {
            pre.next = null;
        }

        ListNode result = rotate;
        while (rotate.next != null) {
            rotate = rotate.next;
        }
        rotate.next = head;
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2};
        int k = 2;
        ListNode.printList(new Leetcode61().rotateRight(ListNode.construct(a), k));
    }
}
