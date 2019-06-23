package list;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chan
 * Date: 2019/6/23 19:44
 * Description:环形链表 II
 */
public class Leetcode142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (set.contains(temp)) return temp;
            set.add(temp);
            temp = temp.next;
        }
        return null;
    }
}
