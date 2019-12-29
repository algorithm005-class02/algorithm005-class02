/**
 * // Definition for a Node.
 * function Node(val, children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
var preorder = function(root) {
  if (!root) return [];
  return helper(root, []);
};

function helper(root, ans = []) {
  if (!root) return;
  ans.push(root.val);
  root.children.forEach(node => helper(node, ans));
  return ans;
}



/**
 * 解法二：迭代
 * // Definition for a Node.
 * function Node(val, children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
var preorder = function(root) {
  if (!root) return [];
  let stack  = [root];
  let ans = [];
  while (stack.length != 0) {
      let current = stack.pop();
      ans.push(current.val);
      for (let i = current.children.length - 1; i >= 0 ; i--) {
          stack.push(current.children[i]);
      }
  }
  return ans;
};