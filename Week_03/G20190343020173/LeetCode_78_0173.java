package org.crayzer.leetcode.editor.en.分治_回溯;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_78_Subsets {
    class Solution2 {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new LinkedList<>();
            if (nums == null) return res;
            res.add(new LinkedList<>());

            for (int i = 0; i < nums.length; i++) {
                int size = res.size();
                for (int j = 0; j < size; j++) {
                    List<Integer> newSubSet = new LinkedList<>(res.get(j));
                    newSubSet.add(nums[i]);
                    res.add(newSubSet);
                }
            }
            return res;
        }
    }

    class Solution1 {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new LinkedList<>();
            if (nums == null) return res;
            dfs(res, nums, new LinkedList<>(), 0);
            return res;
        }

        private void dfs(List<List<Integer>> res, int[] nums, List<Integer> list, int index) {
            // terminator
            if (index == nums.length) {
                res.add(new LinkedList<>(list));
                return;
            }

            dfs(res, nums, list, index + 1);
            list.add(nums[index]);
            dfs(res, nums, list, index + 1);

            // reverse the current states
            list.remove(list.size() - 1);
        }

    }
}
