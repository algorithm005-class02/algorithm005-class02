//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树



//leetcode submit region begin(Prohibit modification and deletion)


import java.util.LinkedList;

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
        LinkedList<Integer> out = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root  == null) {
            return  out;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            out.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return out;
    }


}

public  class TreeNode {
    int val ;
    TreeNode left;
    TreeNode right;
    TreeNode (int s)  {
        val = s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
