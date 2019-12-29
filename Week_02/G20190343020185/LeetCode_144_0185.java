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
        Stack<TreeNode> stack = new Stack();
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        stack.push(root);
        while(!stack.empty()){
            TreeNode tmp = stack.pop();
            if(tmp == null) continue;
            res.add(tmp.val);
            stack.push(tmp.right);
            stack.push(tmp.left);
        }
        return res;
    }
}
