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
var preorderTraversal = function(root) {
  if (!root) return [];
  return helper(root, []);
};

function helper (root, ans = []) {
  if (!root) return;
  ans.push(root.val);
  helper(root.left, ans);
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
var preorderTraversal = function(root) {
  if (!root) return [];
  let stack = [root];
  let ans = [];
  while (stack.length != 0) {
      let current = stack.pop();
      ans.push(current.val);
      if (current.right) stack.push(current.right);
      if (current.left) stack.push(current.left);
  }
  return ans;
};