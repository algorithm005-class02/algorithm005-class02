/**
 * 解法一：递归
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function(root) {
  if (!root) return [];
  let ans = [];
  return helper(root, ans);
};
function helper(root, ans = []) {
  if (!root) return ;
  helper(root.left, ans);
  ans.push(root.val);
  helper(root.right, ans);
  return ans;
}


/**
 * 解法二：迭代
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function(root) {
  if (!root) return [];
  let stack = [];
  let current = root;
  let ans = [];
  while (stack.length != 0 || current) {
      while(current) {
          stack.push(current);
          current = current.left;
      }
      current = stack.pop();
      ans.push(current.val);
      current = current.right;
  }
  return ans;
};