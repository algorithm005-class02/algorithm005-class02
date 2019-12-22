/**
 * 236. 二叉树的最近公共祖先
 */
public class LeetCode_236_0299 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return ans;
    }

    private Boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        if (currentNode == null)
            return false;

        // 左节点递归
        int left = recurseTree(currentNode.left, p, q) ? 1 : 0;
        // 右节点递归
        int right = recurseTree(currentNode.right, p, q) ? 1 : 0;
        // 中节点是否是指定节点
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;

        if (left + right + mid >= 2)
            this.ans = currentNode;

        return left + right + mid > 0;
    }
}
