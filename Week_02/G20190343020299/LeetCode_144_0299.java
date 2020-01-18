import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 */
public class LeetCode_144_0299 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            recursion(root, res);
            return res;
        }

        public void recursion(TreeNode root, List<Integer> res) {

            if (root != null) {
                res.add(root.val);
                if (root.left != null)
                    recursion(root.left, res);

                if (root.right != null)
                    recursion(root.right, res);
            }
        }
    }
}
