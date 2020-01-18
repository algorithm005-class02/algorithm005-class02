/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var minDepth = function(root) {
  if (root === null) {
    return 0;
  }
  const left = minDepth(root.left);
  const right = minDepth(root.right);
  return left === 0 || right === 0
    ? left + right + 1
    : Math.min(left, right) + 1;
};
