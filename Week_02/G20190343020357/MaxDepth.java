package week02.recursion.tree;

public class MaxDepth {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        Integer max = Integer.MIN_VALUE;

        if (root.left != null) {
            max = Math.max(max, maxDepth(root.left));
        }

        if (root.right != null) {
            max = Math.max(max, maxDepth(root.right));
        }
        return max + 1;
    }
}
