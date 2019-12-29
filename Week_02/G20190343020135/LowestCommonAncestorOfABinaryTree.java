
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树

package leetcode.editor.cn;
public class LowestCommonAncestorOfABinaryTree{
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
        TreeNode rootNode = new LowestCommonAncestorOfABinaryTree().new TreeNode(3);
        TreeNode node1 = new LowestCommonAncestorOfABinaryTree().new TreeNode(5);
        TreeNode node2 = new LowestCommonAncestorOfABinaryTree().new TreeNode(6);
        TreeNode node3 = new LowestCommonAncestorOfABinaryTree().new TreeNode(4);
        TreeNode node4 = new LowestCommonAncestorOfABinaryTree().new TreeNode(7);
        TreeNode node5 = new LowestCommonAncestorOfABinaryTree().new TreeNode(1);
        TreeNode node6 = new LowestCommonAncestorOfABinaryTree().new TreeNode(0);
        TreeNode node7 = new LowestCommonAncestorOfABinaryTree().new TreeNode(8);
        TreeNode node8 = new LowestCommonAncestorOfABinaryTree().new TreeNode(2);
        rootNode.left=node1;
        node1.left = node2;
        node1.right = node8;
        node8.left = node4;
        node8.right = node3;
        rootNode.right = node5;
        node5.left = node6;
        node5.right = node7;
        TreeNode treeNode = solution.lowestCommonAncestor(rootNode, node1, node5);
        System.out.println(treeNode.val);


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
    private TreeNode ans;

    public Solution() {
        this.ans = null;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        if (currentNode == null) {
            return false;
        }

        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.recurseTree(root, p, q);
        return this.ans;
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
    