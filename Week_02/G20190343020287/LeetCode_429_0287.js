
// 题目地址 https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
// 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

//      1
//    / | \
//   3  2  4
//  / \
// 5   6


// 返回其层序遍历:

// [
//      [1],
//      [3,2,4],
//      [5,6]
// ]

/*
 * @lc app=leetcode.cn id=429 lang=javascript
 *
 * [429] N叉树的层序遍历
 */

// @lc code=start
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
var levelOrder = function (root) {
  let ret = [];
  let recursion = function (root, arr, floor) {
    if (root === null) {
      return;
    }
    if (arr[floor] === undefined) {
      arr[floor] = [];
    }

    arr[floor].push(root.val)

    for (let i = 0; i < root.children.length; i++) {
      recursion(root.children[i], arr, floor + 1);
    }
  }

  recursion(root, ret, 0);

  return ret
};
// @lc code=end

