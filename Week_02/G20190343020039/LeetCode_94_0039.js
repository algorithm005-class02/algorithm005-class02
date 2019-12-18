/**
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
  let result = [];
  recursion(root, result);
  return result;
};

function recursion(root, result) {
  if (root === null) { return; }
  recursion(root.left, result);
  result.push(root.val);
  recursion(root.right, result);
}
