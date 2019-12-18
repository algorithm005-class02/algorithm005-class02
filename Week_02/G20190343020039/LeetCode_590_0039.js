/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
var postorder = function(root) {
  let result = [];
  recursion(root, result);
  return result;
};

function recursion(root, result) {
  if (root === null) { return; }
  for (let i = 0; i < root.children.length; i += 1) {
    recursion(root.children[i], result);
  }
  result.push(root.val);
}
