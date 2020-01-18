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
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        helper(root, 0);
        return result;
    }

    public void helper(TreeNode node, int depth) {
        List<Integer> tmp = new LinkedList<Integer>();
        if (result.size() == depth) {
            result.add(tmp);
        }
        result.get(depth).add(node.val);
        if(node.left != null) {
            helper(node.left, depth + 1);
        }
        if (node.right != null) {
            helper(node.right, depth + 1);
        }
    }
}