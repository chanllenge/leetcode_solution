package list;

/**
 * Created by chan
 * Date: 2019/6/16 15:25
 * Description:
 */
public class Leetcode141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
        }
        return slow == fast;
    }

    public static void main(String[] args) {

    }
}
