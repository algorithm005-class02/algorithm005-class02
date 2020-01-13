import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的层次遍历
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class Leetcode_102_binaryTreeLevelOrderTraversal {

    /**
     * 方法1：BFS
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0) {
            List<Integer> layer = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode tmp = queue.poll();
                layer.add(tmp.val);
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
                size--;
            }
            res.add(layer);
        }

        return res;
    }

    /**
     * 方法2: DFS
     *  faster than BFS
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }

    private void helper(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        if (level == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);

        helper(root.left, level + 1, res);

        helper(root.right, level + 1, res);

    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
