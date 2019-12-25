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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }
    private void preOrder(TreeNode root, List<Integer> result) {
        if (null != root) {
            result.add(root.val);
            preOrder(root.left, result);
            preOrder(root.right, result);
        }
    }
}