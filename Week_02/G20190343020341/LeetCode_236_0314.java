public class LeetCode_236_0314 {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * 思路： 递归函数（逻辑）：
 *              1. 当前节点为根的子树是否都包含p，q。
 *              2. 都包含，则记录当前节点为候选节点
 *              3. 将当前节点的左子树和右子树作为根执行本递归
 *
 *  思路没毛病，就是耗时太长
 *  执行用时 :
 * 1376 ms
 * , 在所有 java 提交中击败了
 * 5.00%
 * 的用户
 * 内存消耗 :
 * 35.9 MB
 * , 在所有 java 提交中击败了
 * 79.90%
 * 的用户
 */
class Solution {
    private  TreeNode resultTreeNode = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //遍历以当前节点为根的子树 是否都能遍历到p,q。记下当前能遍历到的
        if(root != null) {
            if(findP(root,p) && findQ(root, q)) {
                resultTreeNode = root;
            }
            lowestCommonAncestor(root.left, p, q);
            lowestCommonAncestor(root.right, p, q);
        }
        return resultTreeNode;
    }

    private boolean findP(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root.val == p.val) {
            return true;
        }
        else {
            return findP(root.left, p) || findP(root.right,p);
        }
    }

    private boolean findQ(TreeNode root, TreeNode q) {
        if (root == null) {
            return false;
        }
        if (root.val == q.val) {
            return true;
        }
        else {
            return findQ(root.left, q) || findQ(root.right,q);
        }
    }
}