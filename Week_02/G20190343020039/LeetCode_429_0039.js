/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
  if (root === null) { return []; }
  let result = [];
  let queue = [];
  queue.push(root);
  while (queue.length > 0) {
    let currentLevel = queue;
    queue = [];
    for (let i = 0; i < currentLevel.length; i += 1) {
      let currNode = currentLevel[i];
      for (let j = 0; j < currNode.children.length; j += 1) {
        queue.push(currNode.children[j]);
      }
    }
    result.push(currentLevel.map(e => e.val));
  }
  return result;
};
