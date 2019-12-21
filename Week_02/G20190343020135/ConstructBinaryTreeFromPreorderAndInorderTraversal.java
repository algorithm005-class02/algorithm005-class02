//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组

package leetcode.editor.cn;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = solution.buildTree(preorder, inorder);
        inorder1(treeNode);
    }

    public static void inorder1(TreeNode root){
        if(root != null){
            System.out.println("value : " + root.val);
            if (root.left != null){
                System.out.println("left value : " + root.left.val);
            }
            if (root.right != null) {
                System.out.println("right value : " + root.right.val);
            }
            inorder1(root.left);
            inorder1(root.right);
        }
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
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
    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
        if (in_left == in_right) {
            return null;
        }

        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);

        int index = idx_map.get(root_val);

        pre_idx++;
        root.left = helper(in_left, index);
        root.right = helper(index + 1, in_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }
        return helper(0, inorder.length);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
}
    