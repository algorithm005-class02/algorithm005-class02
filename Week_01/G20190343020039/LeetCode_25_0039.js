/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var reverseKGroup = function(head, k) {
  const dummy = new ListNode();
  dummy.next = head;
  let pre = dummy;
  let end = dummy;
  while (end.next !== null) {
    for (let i = 0; i < k && end !== null; i += 1) {
      end = end.next;
    }
    if (end === null) {
      break;
    }

    let start = pre.next;
    let next = end.next;
    end.next = null;
    pre.next = reverseList(start);
    start.next = next;

    pre = start;
    end = pre;
  }
  return dummy.next;
};

var reverseList = function(head) {
  let [pre, cur] = [null, head];
  while (cur !== null) {
    let next = cur.next;
    cur.next = pre;
    pre = cur;
    cur = next;
  }
  return pre;
};

