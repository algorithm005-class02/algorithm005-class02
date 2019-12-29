import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//您需要在二叉树的每一行中找到最大的值。
//
// 示例：
//
//
//输入:
//
//          1
//         / \
//        3   2
//       / \   \
//      5   3   9
//
//输出: [1, 3, 9]
//
// Related Topics 树 深度优先搜索 广度优先搜索
public class LeetCode_515_二叉树每层的最大值_0011 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            int temp = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.val > temp) temp = node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(temp);
        }
        return result;
    }

}
