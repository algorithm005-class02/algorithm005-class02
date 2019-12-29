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
var postorderTraversal = function(root) {
  if (!root) return [];
  return helper(root, []);
};

function helper (root, ans = []) {
  if (!root) return ;
  helper(root.left, ans);
  helper(root.right, ans);
  ans.push(root.val);
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
var postorderTraversal = function(root) {
  if (!root) return [];
  let stack = [root];
  let ans = [];
  while(stack.length != 0) {
      let current = stack.pop();
      ans.unshift(current.val);
      if (current.left) stack.push(current.left);
      if (current.right) stack.push(current.right);
  }
  return ans;
};