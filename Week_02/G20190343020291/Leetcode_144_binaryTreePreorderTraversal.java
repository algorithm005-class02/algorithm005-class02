import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class Leetcode_144_binaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }
}
