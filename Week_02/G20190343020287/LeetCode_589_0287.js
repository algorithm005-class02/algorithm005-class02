// 题目地址 https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
// 给定一个 N 叉树，返回其节点值的前序遍历。

//      1
//    / | \
//   3  2  4
//  / \
// 5   6

//返回其前序遍历: [1,3,5,6,2,4]

/*
 * @lc app=leetcode.cn id=589 lang=javascript
 *
 * [589] N叉树的前序遍历
 */

// @lc code=start
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
  let ret = [];
  let recursion = function (root, arr) {
    if (root === null) {
      return
    }
    arr.push(root.val);
    for (let i = 0; i < root.children.length; i++) {
      recursion(root.children[i], arr);
    }
  }

  recursion(root, ret);

  return ret;
};
// @lc code=end

