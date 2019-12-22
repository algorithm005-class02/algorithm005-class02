/**
 * 二叉树的最大深度
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class Leetcode_104_maximumDepthOfBinaryTree {

    /**
     * 方法：二叉树的后序遍历
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
