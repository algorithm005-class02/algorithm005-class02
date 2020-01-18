// 题目地址 https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
// 给定一个 N 叉树，返回其节点值的后序遍历。

//      1
//    / | \
//   3  2  4
//  / \
// 5   6

// 返回其后序遍历: [5,6,3,2,4,1]

/*
 * @lc app=leetcode.cn id=590 lang=javascript
 *
 * [590] N叉树的后序遍历
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
 * @return {number[]}
 */
var postorder = function (root) {
  let ret = [];
  let recursion = function (root, arr) {
    if (root === null) {
      return
    }
    for (let i = 0; i < root.children.length; i++) {
      recursion(root.children[i], arr);
    }
    arr.push(root.val);
  }

  recursion(root, ret);

  return ret;
};
// @lc code=end

