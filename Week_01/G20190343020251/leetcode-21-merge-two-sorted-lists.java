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
        // 异常边界判断
        if (l1 == null) return l2;
        if (l2 == null) return l1; 
        
        //设置head节点
        ListNode head = null;
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode node = head;
        
        //合并链表
        while (l1!=null && l2!=null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        
        //剩余链表处理
        if (l1 == null) node.next = l2;
        if (l2 == null) node.next = l1;
        return head; 
    }
}