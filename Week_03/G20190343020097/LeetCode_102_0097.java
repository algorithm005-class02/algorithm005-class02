package G20190343020097;

import java.util.*;

/**
 * * @author jiangli
 * * @date 2019/12/26 14:18
 * * @description binary-tree-level-order-traversal
 */
public class LeetCode_102_0097 {

    private Set<TreeNode> visited = new HashSet<>();

    List<List<Integer>> result = new ArrayList<>();

    /**
     * dfs 递归写法
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) return new ArrayList();
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (visited.contains(node)) return;
        visited.add(node);
        // process current node here.
        if ((result.size() >= level + 1) && result.get(level) != null) {
            result.get(level).add(node.val);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            result.add(level, list);
        }

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }


    /**
     * dfs 广度优先
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.remove();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(list);
        }
        return result;
    }


}
