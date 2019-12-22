package linklist;/**
 * author: Ziv
 * description:
 * Date:Created in
 */

/**
 *
 *
 * @author piper
 * @date 2019/12/15 0:44 
 * @decrisption
 */
public class LeetCode_141_0249 {
    public static void main(String[] args) {
        LeetCode_141_0249 solution = new LeetCode_141_0249();
        ListNode l1 = new ListNode(1);	//创建链表对象 l1 （对应有参 和 无参 构造方法）
        l1.add(2);				//插入结点，打印
        l1.add(3);
        l1.add(4);
        l1.add(5);
        boolean listNode = solution.hasCycle(l1);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode first = head;
        ListNode second = head.next;
        while (first!=second) {
            first = first.next;
            second = second.next.next;
            if(first==second) return true;
        }
        return false;
    }
}
