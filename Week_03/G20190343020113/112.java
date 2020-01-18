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
    public boolean hasPathSum(TreeNode root, int sum) {
        return sumDepth(root, 0, sum);
    }

    public boolean sumDepth(TreeNode root, int sum, int target) {
        if(root == null) return false;
        sum = sum + root.val;
        if(root.left == null && root.right == null) {
            return sum == target;
        }
        return sumDepth(root.left, sum, target) || sumDepth(root.right, sum, target);
    }
}