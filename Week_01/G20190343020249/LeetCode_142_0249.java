package linklist;/**
 * author: Ziv
 * description:
 * Date:Created in
 */

/**
 *
 *
 * @author piper
 * @date 2019/12/15 16:52 
 * @decrisption
 */
public class LeetCode_142_0249 {
    public static void main(String[] args) {
        LeetCode_142_0249 solution = new LeetCode_142_0249();
        ListNode l1 = new ListNode(1);	//创建链表对象 l1 （对应有参 和 无参 构造方法）
        solution.detectCycle(l1);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        ListNode meet = null;
        while (fast !=  null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                meet = fast;
                while (meet != head) {
                    meet = meet.next;
                    head = head.next;
                }
                return meet;
            }
        }
        return null;
    }
}
