package leetcode.week02;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//给定一个二叉树，返回它的 后序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [3,2,1]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树
public class LeetCode_145_二叉树后序遍历_0011 {

    /**
     * 递归
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.val);
    }

    /**
     * 迭代，以前序迭代为基础，每次栈放入两个元素，这样第一次取出根节点时要继续遍历左右，
     * 第二次取出根节点是说明左右已经遍历完，再把根节点取出
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            if (cur == null) continue;
            if (!stack.empty() && cur == stack.peek()) {
                stack.push(cur.right);
                stack.push(cur.right);
                stack.push(cur.left);
                stack.push(cur.left);
            } else {
                result.add(cur.val);
            }
        }
        return result;
    }

}
