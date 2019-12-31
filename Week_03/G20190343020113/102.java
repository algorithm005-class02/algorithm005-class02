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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null) {
            return list;
        }
        List<TreeNode> res = new ArrayList<TreeNode>();
        res.add(root);
        level(res, list);
        return list;
    }

    public void level(List<TreeNode> nodes, List<List<Integer>> list) {
        if(nodes.isEmpty()) {
            return;
        }
        List<Integer> res = new ArrayList<Integer>();
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        for(TreeNode node : nodes) {
            res.add(node.val);
            if(node.left != null) {
                nodeList.add(node.left);
            }
            if(node.right != null) {
                nodeList.add(node.right);
            }
        }
        list.add(res);
        level(nodeList, list);
    }
}