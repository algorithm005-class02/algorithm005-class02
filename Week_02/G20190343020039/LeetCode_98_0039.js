/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isValidBST = function(root) {
  return isValid(root, null, null);
};

function isValid(root, min, max) {
  if (root === null) { return true; }
  if (min !== null && root.val <= min) { return false; }
  if (max !== null && root.val >= max) { return false; }
  return isValid(root.left, min, root.val) &&
    isValid(root.right, root.val, max);
}
