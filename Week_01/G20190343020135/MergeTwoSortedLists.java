//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

package leetcode.editor.cn;
public class MergeTwoSortedLists{
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(4);
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(4);
        ListNode listNode2 = solution.mergeTwoLists(listNode, listNode1);
        while (true) {
            if(listNode2.next != null){
                System.out.println(listNode2.val);
                listNode2 = listNode2.next;
            }else{
                System.out.println(listNode2.val);
                break;
            }
        }
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}