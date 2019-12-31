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
    //解题思路:利用广度搜索，每次获取的node和对应位置进行比较，大于就存入
    List<Integer> result = new LinkedList<Integer>();
    public List<Integer> largestValues(TreeNode root) {
        helper(root, 0);
        return result;
    }

    public void helper(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (result.size() == depth) {
            result.add(node.val);
        }else {
            result.set(depth, Math.max(node.val,result.get(depth)));
        }
        helper(node.left, depth + 1);
        helper(node.right, depth + 1);
    }
}