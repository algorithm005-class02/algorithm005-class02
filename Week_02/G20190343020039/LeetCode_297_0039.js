/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function(root) {
  let result = [];
  serializeDFS(root, result);
  return result.join(",");
};

function serializeDFS(root, result) {
  if (root === null) {
    result.push("null");
    return;
  }
  result.push(root.val);
  serializeDFS(root.left, result);
  serializeDFS(root.right, result);
}

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function(data) {
  let array = data.split(",");
  return deserializeRecursion(array);
};

function deserializeRecursion(array) {
  if (array.length === 0) { return null; }

  let val = array[0];
  if (val === 'null') {
    array.shift();
    return null;
  }

  let node = new TreeNode(+val);
  array.shift();
  node.left = deserializeRecursion(array);
  node.right = deserializeRecursion(array);
  return node;
}

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */
