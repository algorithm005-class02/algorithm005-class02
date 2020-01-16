package org.crayzer.leetcode.editor.en.array;

import java.util.*;

public class LeetCode_15_3Sum {
    class Solution2 {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();

            for (int k = 0; k < nums.length - 2; k++) {
                if (nums[k] > 0) {
                    break;
                }

                if (k > 0 && nums[k] == nums[k - 1]) {
                    continue;
                }
                int i = k + 1, j = nums.length - 1;
                while (i < j) {
                    int sum = nums[k] + nums[i] + nums[j];

                    if (sum < 0) {
                        while (i < j && nums[i] == nums[++i]) ;
                    } else if (sum > 0) {
                        while (i < j && nums[j] == nums[--j]) ;
                    } else {
                        res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                        while (i < j && nums[i] == nums[++i]) ;
                        while (i < j && nums[j] == nums[--j]) ;
                    }
                }
            }

            return res;
        }
    }

    class Solution1 {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Set<List<Integer>> ret = new HashSet<>();

            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> subResult = new ArrayList<>();
                            /** 最小值 */
                            int a = (nums[i] < nums[j] ? nums[i] : nums[j]) < nums[k] ? (nums[i] < nums[j] ? nums[i] : nums[j]) : nums[k];
                            /** 最大值 */
                            int b = (nums[i] > nums[j] ? nums[i] : nums[j]) > nums[k] ? (nums[i] > nums[j] ? nums[i] : nums[j]) : nums[k];
                            int c = 0 - a - b;
                            subResult.add(a);
                            subResult.add(c);
                            subResult.add(b);
                            ret.add(subResult);

                            result.add(subResult);
                        }
                    }
                }
            }

            result.addAll(ret);

            return result;
        }
    }
}
