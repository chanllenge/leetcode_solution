package list;

/**
 * Created by chan
 * Date: 2019/6/7 11:14
 * Description: 合并两个有序列表
 */
public class LeetcodeNo21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            head = head.next;
        }
        head.next = l1 == null ? l2 : l1;
        return dummy.next;
    }


    public static void main(String[] args) {
        int[] a = {1, 4, Integer.MAX_VALUE};
        int[] b = {3,  Integer.MAX_VALUE};
        ListNode result = new LeetcodeNo21().mergeTwoLists(ListNode.construct(a), ListNode.construct(b));
        ListNode.printList(result);
    }
}
