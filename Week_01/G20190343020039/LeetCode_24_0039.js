/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function(head) {
  let dummy = new ListNode();
  dummy.next = head;
  let pre = dummy;
  let cur = head;
  while (cur !== null && cur.next !== null) {
    let post = cur.next;
    cur.next = post.next;
    post.next = cur;
    pre.next = post;
    pre = cur;
    cur = cur.next;
  }
  return dummy.next;
};
