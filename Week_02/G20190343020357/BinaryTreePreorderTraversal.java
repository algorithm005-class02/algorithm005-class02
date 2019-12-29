package week02.recursion.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        helper(root, list);
        return list;
    }

    public void helper(TreeNode cur, List<Integer> list) {
        if (cur != null) {
            list.add(cur.val);
            helper(cur.left, list);
            helper(cur.right, list);
        }
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return list;
    }
}
