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
var maxDepth = function (root) {
    if(!root)  return 0
    var leftHeight = maxDepth(root.left)
    var rightHeight = maxDepth(root.right)
    return Math.max(leftHeight,rightHeight)+1
};