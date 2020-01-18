import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 在每个树行中找最大值
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 */
public class Leetcode_515_findLargestValueInEachTreeRow {

    /**
     * 二叉树节点
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 方法1： BFS
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        bfs(root, res);

        return res;
    }

    private void bfs(TreeNode root, List<Integer> res) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                max = Math.max(max, cur.val);

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(max);
        }
    }


    /**
     * 方法2： DFS
     */

    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res, int level) {
        if (root == null) {
            return;
        }

        if (res.size() <= level) {
            res.add(root.val);
        } else {
            res.set(level, Math.max(res.get(level), root.val));
        }

        dfs(root.left, res, level + 1);
        dfs(root.right, res, level + 1);
    }


}
