package linklist;/**
 * author: Ziv
 * description:
 * Date:Created in
 */

/**
 *
 *
 * @author piper
 * @date 2019/12/14 22:53 
 * @decrisption
 */
public class LeetCode_24_0249 {
    public static void main(String[] args) {
        LeetCode_24_0249 solution = new LeetCode_24_0249();
        ListNode l1 = new ListNode(1);	//创建链表对象 l1 （对应有参 和 无参 构造方法）
        l1.add(2);				//插入结点，打印
        l1.add(3);
        l1.add(4);
        l1.add(5);
//        l1.print();
        ListNode listNode = solution.swapPairs(l1);
        listNode.print();
    }
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            //current的next指针指向 1
            ListNode first = current.next;
            //current的next next指针指向 2
            ListNode second = current.next.next;
            //原本是指向3的指针赋给了1 就变成了 current-->1-->3 2
            first.next = second.next;
            //current刚刚是指向1的，现在指向2  所以现在打印是 current-->2  1
            current.next = second;
            //current的指向就指向了1 所以现在是current-->2-->1-->3-->4-->5
            current.next.next = first;
            //current.next.next就是2，现在给了current，所以说current重新指向了3
            current = current.next.next;
        }
        return dummy.next; //就是刚刚进来指向的head
    }
}
