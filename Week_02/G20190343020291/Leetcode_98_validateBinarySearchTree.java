/**
 * 验证二叉搜索树
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class Leetcode_98_validateBinarySearchTree {

    /**
     * 方法1：使用二叉搜索树的定义
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }

        int val = root.val;
        if ((lower != null && val <= lower) || (upper != null && val >= upper)) {
            return false;
        }

        return helper(root.left, lower, root.val) && helper(root.right, root.val, upper);
    }

    /**
     * 方法2：使用中序遍历
     */
    TreeNode prev;

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (prev != null && prev.val >= root.val) {
            return false;
        }

        prev = root;
        return isValidBST(root.right);
    }
}
