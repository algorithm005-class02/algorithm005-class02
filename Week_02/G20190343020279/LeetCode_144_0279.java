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
    public List<Integer> preorderTraversal(TreeNode root) {
        // 1.定义一个作为返回结果的List
        List<Integer> res = new ArrayList();
        // 2.递归函数实现
        recursionMachine(root,res);
        return res;
    }
    // 3.定义一个辅助函数来实现前序遍历递归
    public void recursionMachine(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            recursionMachine(root.left,res);
            recursionMachine(root.right,res);
        }
    }
}
