package org.crayzer.leetcode.editor.en.分治_回溯;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_46_Permutations {

    class Solution {

        private List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> permute(int[] nums) {
            if (nums == null) return res;
            doBackTrack(new LinkedList<>(), nums);
            return res;
        }

        private void doBackTrack(LinkedList<Integer> track, int[] nums) {
            if (track.size() == nums.length) {
                res.add(new LinkedList<>(track));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (track.contains(nums[i])) continue;
                track.add(nums[i]);
                doBackTrack(track, nums);
                track.removeLast();
            }
        }
    }
}
