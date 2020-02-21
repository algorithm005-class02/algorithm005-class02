/**
 * 二叉树的最小深度
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class Leetcode_111_minimumDepthOfBinaryTree {

    /**
     * 方法：后序遍历二叉树
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return (left == 0 || right == 0) ? (left + right + 1) : Math.min(left, right) + 1;
    }

}
