// 589. N叉树的前序遍历
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
var preorder = function (root) {
    if (!root) {
        return [];
    }
    var temp = [];
    for (let item of root.children) {
        temp.push(...preorder(item))
    }
    return [root.val, ...temp];
};