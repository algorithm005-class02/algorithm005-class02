package com.divider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums == null) return list;
        dfs(list, nums, new ArrayList<Integer>(), 0);
        return list;
    }

    private void dfs(List<List<Integer>> list, int[] nums, List<Integer> tempList, int index) {
        if (index == nums.length) {
            list.add(new ArrayList<Integer>(tempList));
            return;
        }

        dfs(list, nums, tempList, index + 1);
        tempList.add(nums[index]);
        dfs(list, nums, tempList, index + 1);

        tempList.remove(tempList.size() - 1);
    }
}
