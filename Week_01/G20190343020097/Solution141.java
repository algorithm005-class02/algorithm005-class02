package G20190343020097;

import java.util.HashSet;
import java.util.Set;

/**
 *  * @author jiangli
 *  * @date 2019/12/12 21:46
 *  * @description 环形链表
 *  
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        boolean flag = false;
        while (head.next != null) {
            if (set.contains(head.next.val)) {
                flag = true;
            }
            set.add(head.val);
            head = head.next;
        }
        return flag;
    }
}
