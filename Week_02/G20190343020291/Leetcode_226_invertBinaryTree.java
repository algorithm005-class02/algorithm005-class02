/**
 * 翻转二叉树
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class Leetcode_226_invertBinaryTree {


    /**
     * 方法：后序遍历二叉树
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode newLeft = invertTree(root.right);
        TreeNode newRight = invertTree(root.left);

        root.left = newLeft;
        root.right = newRight;
        return root;
    }
}
