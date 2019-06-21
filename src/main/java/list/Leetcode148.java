package list;

/**
 * Created by chan
 * Date: 2019/6/20 7:20
 * Description:
 */
public class Leetcode148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = findMid(head);
        ListNode temp = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        return mergeList(left, right);

    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), head = dummy;

        while (l1 != null && l2 != null) {
            int value;
            if (l1.val <= l2.val) {
                value = l1.val;
                l1 = l1.next;
            } else {
                value = l2.val;
                l2 = l2.next;
            }
            head.next = new ListNode(value);
            head = head.next;
        }

        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] a = {4, 3, 1, 2};
        ListNode.printList(new Leetcode148().sortList(ListNode.construct(a)));
    }
}
