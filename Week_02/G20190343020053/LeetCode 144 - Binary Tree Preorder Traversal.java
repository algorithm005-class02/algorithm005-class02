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
        if (root == null) {
            return new ArrayList<>(0);
        }
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        process(res, root.left);
        process(res, root.right);
        return res;
    }
    
    private void process(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        process(res, root.left);
        process(res, root.right);
    }
}