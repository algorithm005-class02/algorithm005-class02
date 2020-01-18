package org.crayzer.leetcode.editor.en.分治_回溯;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_77_Combinations {
    class Solution {
        private List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> combine(int n, int k) {
            if (n <= 0 || k <= 0 || n < k) return res;
            doBackTrack(n, k, new LinkedList<>(), 1);
            return res;
        }

        private void doBackTrack(int n, int k, LinkedList<Integer> track, int begin) {
            if (track.size() == k) {
                res.add(new LinkedList<>(track));
                return;
            }

            for (int i = begin; i <= (n - (k - track.size()) + 1); i++) {
                track.add(i);
                doBackTrack(n, k, track, i + 1);
                track.removeLast();
            }
        }
    }
}