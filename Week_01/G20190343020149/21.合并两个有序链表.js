/*
 * @lc app=leetcode.cn id=21 lang=javascript
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    if( l1 === null ) return l2;
    if( l2 === null ) return l1;
    const val0 = l1.val;
    const val1 = l2.val;

    //设定 l1 的起始节点总比 l2 的起始节点小
    if( val0 > val1 ){
        let temp;
        temp = l1;
        l1 = l2;
        l2 = temp;
    }
    let root = l1;
    //交替插入
    while( l1 && l2 ){
        let inserNode = findInsertNode( l1, l2.val );
        let tempNode = inserNode.next;
        inserNode.next = l2;
        l1 = l2;
        l2 = tempNode;
    }
    return root;
};

/**
 * @param {ListNode} list
 * @param {int} val
 * @return {ListNode}
 */
function findInsertNode( list, val ){
    while( list.next ){
        if( list.next.val > val ){
            break;
        }
        list = list.next;
    }
    return list;
}
// @lc code=end

