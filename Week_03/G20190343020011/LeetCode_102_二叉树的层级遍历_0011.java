import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
//
// 例如:
//给定二叉树: [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层次遍历结果：
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索
public class LeetCode_102_二叉树的层级遍历_0011 {

    /**
     * 广度优先搜索，递归法
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        helper(queue, result);
        return result;
    }

    private void helper(LinkedList<TreeNode> queue, List<List<Integer>> result) {
        if (queue.isEmpty()) {
            return;
        }
        int n = queue.size();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            TreeNode node = queue.pollFirst();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        result.add(list);
        helper(queue, result);
    }

    /**
     * 广度优先搜索，迭代法
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.pollFirst();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    /**
     * 深度优先搜索
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        helper2(root, 0, result);
        return result;
    }

    private void helper2(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) return;
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        helper2(node.left, level + 1, result);
        helper2(node.right, level + 1, result);
    }

}
