//236. 二叉树的最近公共祖先
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode answer;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurise(root, p, q);
        return answer;
    }

    private boolean recurise(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) {
            return false;
        }
        int left = recurise(root.left, p, q) ? 1 : 0;
        int right = recurise(root.right, p ,q) ? 1 : 0;
        int middle = (root.val == p.val || root.val == q.val) ? 1 : 0;
        if (left + right + middle >= 2) {
            answer = root;
        }
        return (left + right + middle) > 0;
    }
}