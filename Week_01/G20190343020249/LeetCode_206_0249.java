package linklist;/**
 * author: Ziv
 * description:
 * Date:Created in
 */

/**
 *
 *
 * @author piper
 * @date 2019/12/13 23:54 
 * @decrisption
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);	//创建链表对象 l1 （对应有参 和 无参 构造方法）
        l1.add(2);				//插入结点，打印
        l1.add(3);
        l1.add(4);
        l1.add(5);
//        l1.print();
        ListNode listNode = solution.reverseList(l1);
        listNode.print();
    }

    public ListNode reverseList(ListNode head) {
        //申请节点，pre和 cur，pre指向null
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while(cur!=null) {
            //记录当前节点的下一个节点 就是指向了2的地址给了tmp
            tmp = cur.next;
            //第一次的时候pre为空，所以cur.next是空的，然后巧妙的是， 当遍历第二次的时候，pre已经是1，cur为2，所以（cur.next = pre这句话的意思是：2的next指针就会指向1的地址（1的头节点，这个是时候链表就会变成1<--2  3-->4-->5 ）
            cur.next = pre;
            //pre和cur节点都前进一位。第一次遍历的时候， 1的地址给了pre
            pre = cur;
            //第一次遍历的时候，（tmp = cur.next;这个时候记录的作用就是这时候体现）指向2的地址给了cur，第一次的时候2的next指针并未指向1的地址，但是链表已经变成了 1 2-->3-->4-->5
            cur = tmp;
        }
        return pre;
    }
}
