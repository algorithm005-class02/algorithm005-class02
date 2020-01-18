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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null) {
            return list;
        }
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        nodes.add(root);
        level(nodes, 1, list);
        return list;
    }

    public void level(List<TreeNode> nodes, int n, List<List<Integer>> list) {
        if(nodes.isEmpty()) {
            return;
        }
        List<Integer> res = new ArrayList<Integer>();
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        for(TreeNode node : nodes) {
            if(n % 2 == 0) {
                res.add(0, node.val);
            } else {
                res.add(node.val);
            }
            if(node.left != null) nodeList.add(node.left);
            if(node.right != null) nodeList.add(node.right);
        }
        list.add(res);
        level(nodeList, n + 1, list);
    }
}