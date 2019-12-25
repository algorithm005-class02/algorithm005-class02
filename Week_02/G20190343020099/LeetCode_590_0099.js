/**
 * 解法一：递归
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
var postorder = function(root) {
  if (!root) return [];
  return helper(root, []);
};
function helper(root, ans) {
  if (!root) return ;
  if (root.children) {
      root.children.forEach(item => helper(item, ans));
  }
  ans.push(root.val);
  return ans;
}


/**
 * 解法二：迭代
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
var postorder = function(root) {
  if (!root) return [];
  let stack = [root];
  let ans = [];
  while (stack.length != 0) {
      let current = stack.pop();
      ans.unshift(current.val);
      current.children.forEach(item => stack.push(item));
  }
  return ans;
};