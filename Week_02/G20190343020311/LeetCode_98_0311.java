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
    public boolean isValidBST(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        inorder(root, traversal);
        for (int i = 0; i < traversal.size() - 1; i++) {
            if (traversal.get(i) >= traversal.get(i+1)) return false;
        }
        return true;
    }

    public void inorder(TreeNode root, List<Integer> t) {
        if (root != null) {
            if (root.left != null) {
                inorder(root.left, t);
            }
            t.add(root.val);
            if (root.right != null) {
                inorder(root.right, t);
            }
        }
    }
}