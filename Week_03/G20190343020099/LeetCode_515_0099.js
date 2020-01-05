/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * 解法二：BFS
 * @param {TreeNode} root
 * @return {number[]}
 */
var largestValues = function(root) {
  if (!root) return [];
  let queue = [root];
  let ans = [];
  while(queue.length) {
      let len = queue.length;
      let currentMax = -Infinity;
      while (len--) {
          let node = queue.shift();
          currentMax = Math.max(currentMax, node.val);
          if (node.left) queue.push(node.left);
          if (node.right) queue.push(node.right);
      }
      ans.push(currentMax);
  }
  return ans;
};


/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * 解法二：DFS
 * @param {TreeNode} root
 * @return {number[]}
 */
var largestValues = function(root) {
  if (!root) return [];
  let ans = [];
  dfs(ans, root, 0);
  return ans;
};

function dfs (ans, root, layer) {
  if (!root) return ;
  if (ans[layer] == null || ans[layer] < root.val) ans[layer] = root.val;
  if(root.left) dfs (ans, root.left, layer + 1);
  if(root.right) dfs (ans, root.right, layer + 1);
}