/**
 * @method "递归法"
 * @explain 直截了当。我们可以定义一个辅助函数来实现递归。
 * @complexity 时间复杂度：O(n),空间复杂度：O(n)
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 1.定义一个作为返回结果的List
        List<Integer> res = new ArrayList();
        // 2.递归函数实现
        helper(root,res);
        return res;
    }
    // 3.定义一个辅助函数来实现中序遍历递归
    public void helper(TreeNode root,List<Integer> res){
        if (root != null) {
            helper(root.left,res);
            res.add(root.val);
            helper(root.right,res);
        }
    }
}
