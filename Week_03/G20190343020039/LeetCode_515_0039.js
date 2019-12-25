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
var largestValues = function(root) {
  if (root === null || root.length === 0) {
    return [];
  }
  let result = [];
  let queue = [];
  queue.push(root);
  while (queue.length > 0) {
    const currentLevel = queue;
    queue = [];

    let curMax = currentLevel[0];
    for (let i = 1; i < currentLevel.length; i += 1) {
      if (currentLevel[i].val > curMax.val) {
        curMax = currentLevel[i]
      }
    }
    result.push(curMax.val);

    for (let i = 0; i < currentLevel.length; i += 1) {
      const node = currentLevel[i];
      if (node.left) { queue.push(node.left); }
      if (node.right) { queue.push(node.right); }
    }
  }
  return result;
};
