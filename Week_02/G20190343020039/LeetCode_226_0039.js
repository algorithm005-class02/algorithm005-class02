/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var invertTree = function(root) {
  if (!root) { return root; }
  const left = root.left;
  const right = root.right;
  root.right = invertTree(left);
  root.left = invertTree(right);
  return root;
};
