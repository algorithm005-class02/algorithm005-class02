/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function(preorder, inorder) {
  if (preorder.length === 0 || inorder.length === 0) {
    return null;
  }
  let val = preorder[0];
  let idx = inorder.indexOf(val);
  let node = new TreeNode(val);
  node.left = buildTree(preorder.slice(1, 1+idx), inorder.slice(0, idx));
  node.right = buildTree(preorder.slice(1+idx), inorder.slice(idx+1));
  return node;
};
