package linklist;/**
 * author: Ziv
 * description:
 * Date:Created in
 */

/**
 *
 *
 * @author piper
 * @date 2019/12/15 18:11 
 * @decrisption
 */
public class LeetCode_25_0249 {
    public static void main(String[] args) {
        LeetCode_25_0249 solution = new LeetCode_25_0249();
        ListNode l1 = new ListNode(1);	//创建链表对象 l1 （对应有参 和 无参 构造方法）
        l1.add(2);				//插入结点，打印
        l1.add(3);
        l1.add(4);
        l1.add(5);
        l1.add(6);
        l1.add(7);

//        l1.print();
        ListNode listNode = solution.reverseKGroup(l1,3);
        listNode.print();
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next; //上面遍历完，pre.next就是指向1 start=1
            ListNode next = end.next; //上面遍历完，end.next就是指向4 也就是next=4
            end.next = null; //第一次遍历这里就是变成了0-->1-->2-->3 4-->5-->6-->7
            pre.next = reverse(start); //第一次遍历之后就变成了,然后0的指针重新指向了3， 0>-->3-->2-->1
            start.next = next;  //这里就是1的next指针指向了4 0>-->3-->2-->1-->4-->5-->6-->7
            pre = start;  //这里就是把1的地址给了pre
            end = pre;   //这里就是把1的地址给了end
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) { //第一次传过来的是1-->2-->3 注意3的next指针是null
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre; //第一次遍历1（1的next指针置空）2-->3  第二次遍历就变成了1<--2 3）（2的指针指向了1) 第三次遍历就变成了 1<--2<--3
            pre = curr;     //第一次遍历，把1的值给了pre
            curr = next;    //第一次遍历，把2的值给了curr，相当与往后移一位
        }
        return pre;
    }
}
