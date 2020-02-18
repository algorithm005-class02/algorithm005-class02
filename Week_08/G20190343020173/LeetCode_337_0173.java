package org.crayzer.leetcode.editor.en.dynamic_programming;

import org.crayzer.leetcode.editor.en.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_337_HouseRobber3 {

    class Solution1 {
        public int rob(TreeNode root) {
            int[] res = dp(root);
            return Math.max(res[0], res[1]);
        }

        int[] dp(TreeNode root) {
            if (root == null)
                return new int[]{0, 0};
            int[] left = dp(root.left);
            int[] right = dp(root.right);
            // 抢，下家就不能抢了
            int rob = root.val + left[0] + right[0];
            // 不抢，下家可抢可不抢，取决于收益大小
            int not_rob = Math.max(left[0], left[1])
                    + Math.max(right[0], right[1]);

            return new int[]{not_rob, rob};
        }
    }

    class Solution {
        private Map<TreeNode, Integer> memo = new HashMap<>();
        public int rob(TreeNode root) {
            if (root == null) return 0;
            if (memo.containsKey(root)) return memo.get(root);
            int do_rob = root.val
                    + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                    + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
            int not_rob = rob(root.left) + rob(root.right);
            int res = Math.max(do_rob, not_rob);
            return res;
        }
    }
}
