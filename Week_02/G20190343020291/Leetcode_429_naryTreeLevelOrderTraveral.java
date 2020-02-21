import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * N叉树的层次遍历
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 */
public class Leetcode_429_naryTreeLevelOrderTraveral {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> curLayer = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                curLayer.add(cur.val);

                for (Node child : cur.children) {
                    if (child != null) {
                        queue.add(child);
                    }
                }
            }
            res.add(curLayer);
        }

        return res;
    }
}
