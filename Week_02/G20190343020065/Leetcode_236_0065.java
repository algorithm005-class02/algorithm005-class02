public class Leetcode_236_0065 {
    /*
    思路:递归实现在左、有子树中分别查找是否包含p或q
       -如果左子树包含p，右子树包含q；或者左子树包含q，右子树包含p，那么该根节点就是最近公共祖先
       -如果左子树包含p和q，那么最近公共祖先在左子树中，进入left子树继续查找
       -如果右子树包含p和q，那么最近公共祖先在右子树中，进入right子树继续查找
       -继续上述查找方法
    */
   class Solution {
       public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
           if (root == null || root == p || root == q) return root;
           TreeNode left = lowestCommonAncestor(root.left, p, q);
           TreeNode right = lowestCommonAncestor(root.right, p, q);
           return left == null ? right : (right == null ? left : root);
       }
   }
}
