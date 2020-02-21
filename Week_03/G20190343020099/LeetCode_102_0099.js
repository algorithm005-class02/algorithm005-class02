/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * 解法一
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
  if (!root || root.length < 1) return [];
  let ans = [];
  bfs(ans, root)
  return ans;
};

function bfs (ans, root) {
  let queue = [[root, 0]];
  while (queue.length) {
      let [current, layer] = queue.shift();
      ans[layer] ? ans[layer].push(current.val) : ans[layer] = [current.val];
      if (current.left) queue.push([current.left, layer + 1]);
      if (current.right) queue.push([current.right, layer + 1]);
  }
}


/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * 解法二
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
  if (!root || root.length < 1) return [];
  let ans = [];
  dfs(ans, root)
  return ans;
};

function dfs (ans, root) {
  let queue = [[root, 0]];
  while (queue.length) {
      let [current, layer] = queue.pop();
      ans[layer] ? ans[layer].push(current.val) : ans[layer] = [current.val];
      if (current.right) queue.push([current.right, layer + 1]);
      if (current.left) queue.push([current.left, layer + 1]);
  }
}

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * 解法三
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
  if (!root || root.length < 1) return [];
  let ans = [];
  dfs (ans, root, 0);
  return ans;
};
function  dfs (ans, root, layer) {
  if (!root) return ;
  if (!ans[layer]) ans[layer] = [];
  ans[layer].push(root.val);
  dfs(ans, root.left, layer + 1);
  dfs(ans, root.right, layer + 1);
}