package list;

import java.util.Arrays;
import java.util.List;

/**
 * Created by chan
 * Date: 2019/6/16 10:15
 * Description:
 */
public class Leetcode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return recurMerge(lists);
    }

    private ListNode recurMerge(ListNode[] listNodes) {
        if (listNodes.length == 1) return listNodes[0];
        if (listNodes.length == 2) return mergeTwoLists(listNodes[0], listNodes[1]);

        int len = listNodes.length;
        int mid = len % 2 == 0 ? len / 2 : len / 2 + 1;
        ListNode left = recurMerge(Arrays.copyOfRange(listNodes, 0, mid));
        ListNode right = recurMerge(Arrays.copyOfRange(listNodes, mid, len));
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
        int[] c = {2,  5};
        ListNode[] listNodes = {};
        ListNode.printList(new Leetcode23().mergeKLists(listNodes));
    }
}
