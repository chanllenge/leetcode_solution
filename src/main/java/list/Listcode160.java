package list;

/**
 * Created by chan
 * Date: 2019/6/21 22:06
 * Description:相交链表
 */
public class Listcode160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int m = 0, n = 0;
        ListNode tempA = headA;
        while (tempA != null) {
            m++;
            tempA = tempA.next;
        }
        ListNode tempB = headB;
        while (tempB != null) {
            n++;
            tempB = tempB.next;
        }
        int len = m > n ? m - n : n - m;
        if (m > n) {
            while (len > 0) {
                headA = headA.next;
                len--;
            }
        } else {
            while (len > 0) {
                headB = headB.next;
                len--;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
