import java.util.ArrayList;
import java.util.List;

/**
  
https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
给定一个二叉树，返回它的 前序 遍历。

 示例:

输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [1,2,3]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */ 

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
    /**
     * 方法一：递归遍历
     * 时间复杂度：O(n)。
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    // 前序遍历
    public void helper(TreeNode root, List <Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null) {
                helper(root.left, res);
            }
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }
    
}