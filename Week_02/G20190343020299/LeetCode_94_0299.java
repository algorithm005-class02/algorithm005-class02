import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 */
public class LeetCode_94_0299 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursion(root, res);
        return res;
    }

    public void recursion(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null)
                recursion(root.left, res);

            res.add(root.val);

            if (root.right != null)
                recursion(root.right, res);
        }
    }
}


