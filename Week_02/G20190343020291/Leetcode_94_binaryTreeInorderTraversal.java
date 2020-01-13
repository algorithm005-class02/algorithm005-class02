import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */

public class Leetcode_94_binaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
