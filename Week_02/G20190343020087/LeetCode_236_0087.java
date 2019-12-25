import org.graalvm.compiler.debug.CSVUtil.Escape;

import jdk.nashorn.api.tree.BinaryTree;

/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件：找到返回root, 直到 没有子树也找不到就返回null（root.left/right == null）
        // 由上一层的 left/right 接收这层的返回值
        if (root == null) return null;
        if (root == p || root == q) return root;
        // 循环体：递归左右子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 判断条件：首先注意层级顺序
        // 左子树找不到，就在右子树找
        if (left == null) return right;
        // 此时右子树没有q/p，就在左子树找q/p
        else if (right == null) return left;
        //root.left 和 root.right两个子树都有，那就返回这两个子树的根root
        else return root;
    }
}
// @lc code=end

