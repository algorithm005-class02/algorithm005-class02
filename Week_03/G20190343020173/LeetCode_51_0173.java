package org.crayzer.leetcode.editor.en.分治_回溯;

import java.util.*;

public class LeetCode_51_NQueens {
    static class Solution {

        private Set<Integer> cols = new HashSet<>();
        private Set<Integer> pie = new HashSet<>();
        private Set<Integer> na = new HashSet<>();
        private List<List<String>> res;

        public List<List<String>> solveNQueens(int n) {
            if (n < 1) return new ArrayList<>();
            res = new LinkedList<>();
            dfs(n, 0, new LinkedList<>());
            return res;
        }

        private void dfs(int n, int row, LinkedList<Integer> track) {
            if (row >= n) {
                List<String> board = convert2Board(track, n);
                res.add(board);
                return;
            }

            for (int col = 0; col < n; col++) {
                if (cols.contains(col) || pie.contains(row + col) || na.contains(row - col)) continue;

                cols.add(col);
                pie.add(row + col);
                na.add(row - col);
                track.add(col);
                dfs(n, row + 1, track);
                cols.remove(col);
                pie.remove(row + col);
                na.remove(row - col);
                track.removeLast();
            }
        }

        private List<String> convert2Board(LinkedList<Integer> track, int n) {
            List<String> board = new LinkedList<>();
            for (int num : track) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < n; i++) builder.append(".");
                builder.replace(num, num + 1, "Q");
                board.add(builder.toString());
            }
            return board;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        Solution solution = new Solution();
        List<List<String>> res = solution.solveNQueens(n);
        System.out.println(res);
    }
}
