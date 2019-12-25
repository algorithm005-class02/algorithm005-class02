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
  let result = [];
  recursion(root, result);
  return result;
};

function recursion(root, result) {
  if (root === null) {
    return;
  }
  result.push(root.val);
  for (let i = 0; i < root.children.length; i += 1) {
    recursion(root.children[i], result);
  }
}
