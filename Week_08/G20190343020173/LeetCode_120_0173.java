package org.crayzer.leetcode.editor.en.dynamic_programming;

import java.util.List;

public class LeetCode_120_Triangle {
    class Solution3 {
        public int minimumTriangle(List<List<Integer>> triangle) {
            int row = triangle.size();
            int[] minLen = new int[row + 1];

            for (int level = row - 1; level >= 0 ; level--) {
                for (int i = 0; i <= level; i++) {
                    minLen[i] = Math.min(minLen[i], minLen[i + 1]) + triangle.get(level).get(i);
                }
            }
            return minLen[0];
        }
    }

    class Solution2 {
        int row;
        Integer[][] memo;

        public int minimumTotal(List<List<Integer>> triangle) {
            row =  triangle.size();
            memo = new Integer[row][row];
            return recursion(0, 0, triangle);
        }

        private int recursion(int level, int c, List<List<Integer>> triangle) {
            if (memo[level][c] != null) return memo[level][c];
            if (level == row - 1) return memo[level][c] = triangle.get(level).get(c);

            int left = recursion(level + 1, c, triangle);
            int right = recursion(level + 1, c + 1, triangle);
            return memo[level][c] = Math.min(left, right) + triangle.get(level).get(c);
        }
    }

    class Solution1 {
        int row;
        public int minimumTotal(List<List<Integer>> triangle) {
            row = triangle.size();
            return recursion(0, 0, triangle);
        }

        private int recursion(int level, int c, List<List<Integer>> triangle) {
            if (level == row - 1) return triangle.get(level).get(c);

            int left = recursion(level + 1, c, triangle);
            int right = recursion(level + 1, c + 1, triangle);
            return Math.min(left, right) + triangle.get(level).get(c);
        }
    }
}
