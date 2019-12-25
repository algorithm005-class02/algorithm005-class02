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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        reverseTree(root);
        return root;
    }

    public void reverseTree(TreeNode root) {
        TreeNode cur;
        if(root.left == null && root.right == null) {
            return;
        }
        cur = root.left;
        root.left = root.right;
        root.right = cur;
        if(root.left != null) {
            reverseTree(root.left);
        }
        if(root.right != null) {
            reverseTree(root.right);
        }
    }
}