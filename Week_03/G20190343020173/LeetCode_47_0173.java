package org.crayzer.leetcode.editor.en.分治_回溯;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_47_Permutations2 {
    class Solution {

        private List<List<Integer>> res = new LinkedList<>();
        private boolean[] used;

        public List<List<Integer>> permuteUnique(int[] nums) {
            if (nums == null) return res;
            Arrays.sort(nums);
            used = new boolean[nums.length];
            doBackTrack(nums, new LinkedList<>(), 0);
            return res;
        }

        public void doBackTrack(int[] nums, LinkedList<Integer> track, int index) {
            if (index == nums.length) {
                res.add(new LinkedList<>(track));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

                    used[i] = true;
                    track.add(nums[i]);
                    doBackTrack(nums, track, index + 1);
                    track.removeLast();
                    used[i] = false;
                }
            }
        }
    }
}

