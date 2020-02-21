/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
  if (root === null) { return []; }
  let result = [];
  let queue = [];
  queue.push(root);
  while (queue.length > 0) {
    const levelSize = queue.length;
    const currentLevel = [];
    for (let i = 0; i < levelSize; i += 1) {
      let node = queue.shift();
      currentLevel.push(node.val);
      if (node.left) { queue.push(node.left); }
      if (node.right) { queue.push(node.right); }
    }
    result.push(currentLevel);
  }
  return result;
};
