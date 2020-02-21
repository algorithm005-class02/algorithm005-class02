import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;



/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //递归调用法
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     inorderTraversal(root, res);
    //     return res;
    // }

    // private void inorderTraversal(TreeNode root , List<Integer> res) {
    //     if (root != null) {
    //         inorderTraversal(root.left, res);
    //         res.add(root.val);
    //         inorderTraversal(root.right, res);
    //     }
    // }

    //使用栈模拟递归过程 循环
    //但是好像破坏了树原有的结构啊。。。
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     Stack<TreeNode> stack = new Stack<>();
    //     List<Integer> res = new ArrayList<>();
    //     stack.push(root);
    //     while (root != null && !stack.isEmpty()) {
    //         TreeNode node = stack.pop();
    //         if (node.left != null || node.right != null) {
    //             if (node.right != null) stack.push(node.right);
    //             node.right = null;
    //             stack.push(node);
    //             if (node.left != null) stack.push(node.left);
    //             node.left = null;
    //         } else {
    //             res.add(node.val);
    //         }
    //     }
    //     return res;
    // }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
     

}
// @lc code=end

