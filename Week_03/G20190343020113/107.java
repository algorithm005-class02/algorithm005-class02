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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        if(root == null) {
            return list;
        }
        nodes.add(root);
        layer(nodes, list);
        return list;
    }

    public void layer(List<TreeNode> nodes, List<List<Integer>> list) {
        if (nodes.isEmpty()) {
            return;
        }
        List<Integer> res = new ArrayList<Integer>();
        List<TreeNode> nextNodes = new ArrayList<TreeNode>();
        for (TreeNode node : nodes) {
            res.add(node.val);
            if (node.left != null) {
                nextNodes.add(node.left);
            }
            if (node.right != null) {
                nextNodes.add(node.right);
            }
        }
        list.add(0, res);
        layer(nextNodes, list);
    }
}