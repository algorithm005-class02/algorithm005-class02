/**
 * 解法一：递归
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
  if (!root) return [];
  let ans = [];
  helper(root, 0, ans);
  return ans;
};

function helper(root, layer = 0, ans = []) {
  if (!root) return null;
  if (ans.length <= layer) ans.push([]);
  ans[layer].push(root.val);
  root.children.forEach(node => helper(node, layer + 1, ans))
}


/**
 * 解法二：迭代
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
  if (!root) return [];
  let queue = [root];
  let ans = [[root.val]];
  while(queue.length != 0) {
      let level = [];
      let current = queue.shift();
      current.children.forEach(node => {
          level.push(node.val);
          if (node.children && node.children.length > 0) {
              queue.push(node)
          }
      })
      ans.push(level);
  }
  return ans;
};


/**
 * 解法三：优化版迭代
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
  if (!root) return [];
  let queue = [root];
  let ans = [];
  while(queue.length) {
      let level = [];
      let len = queue.length;
      let currentQueue = [];
      for (let i = 0; i < len; i++) {
          let current = queue[i];
          level.push(current.val);
          if (current.children && current.children.length > 0) {
              currentQueue.push(...current.children);
          }
      }
      queue = currentQueue;
      ans.push(level);
  }
  return ans;
};