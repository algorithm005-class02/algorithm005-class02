package leetcode.week02;

import util.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//给定一个 N 叉树，返回其节点值的前序遍历。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其前序遍历: [1,3,5,6,2,4]。
//
//
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树
public class LeetCode_589_N叉树前序遍历_0011 {

    /**
     * 递归
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(Node root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        for (Node node : root.children) {
            helper(node, result);
        }
    }

    /**
     * 迭代
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node cur = stack.pop();
            result.add(cur.val);
            if (cur.children == null || cur.children.size() == 0) continue;
            for (int i = cur.children.size() - 1; i >= 0; i--) {
                stack.push(cur.children.get(i));
            }
        }
        return result;
    }

}
