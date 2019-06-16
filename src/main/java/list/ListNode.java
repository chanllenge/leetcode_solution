package list;

/**
 * Created by chan
 * Date: 2019/6/7 10:57
 * Description:
 */
public class ListNode {

    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    public static ListNode construct(int[] value) {
        ListNode node = new ListNode(value[0]);
        ListNode head = node;
        for (int i = 1; i < value.length; i++) {
            node.next = new ListNode(value[i]);
            node = node.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            if (head.next != null)
                System.out.print(head.val + "->");
            else
                System.out.print(head.val);
            head = head.next;
        }
    }
}
