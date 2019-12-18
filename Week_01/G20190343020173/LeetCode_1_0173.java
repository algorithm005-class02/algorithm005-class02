package org.crayzer.leetcode.editor.en.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_TwoSum {

    class Solution3 {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null) {
                return null;
            }

            int[] sortedOfOriginal = Arrays.copyOf(nums, nums.length);
            Arrays.sort(sortedOfOriginal);// O(nlogn)

            int val_0 = 0, val_1 = 0;
            int start = 0, end = sortedOfOriginal.length - 1;
            int sum;

            while (start < end) {
                sum = sortedOfOriginal[start] + sortedOfOriginal[end];
                if (sum < target) {
                    start++;
                } else if (sum > target) {
                    end--;
                } else {
                    val_0 = sortedOfOriginal[start];
                    val_1 = sortedOfOriginal[end];
                    break;
                }
            }

            int[] result = new int[2];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == val_0) {
                    result[0] = i;
                    break;
                }
            }

            if (val_0 != val_1) {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == val_1) {
                        result[1] = i;
                        break;
                    }
                }
            } else {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == val_1 && i != result[0]) {
                        result[1] = i;
                        break;
                    }
                }
            }

            return result;
        }
    }

    class Solution21 {
        public int[] twoSum(int[] nums, int target) {

            Map<Integer, Integer> map = new HashMap<>(16);

            for (int i = 0; i < nums.length; i++) {

                if (map.containsKey(target - nums[i])) {
                    return new int[]{map.get(target - nums[i]), i};
                }

                map.put(nums[i], i);
            }

            throw new IllegalArgumentException("No two sum solution");
        }
    }

    // class Solution2 {
    //     public int[] twoSum(int[] nums, int target) {
    //
    //         Map<Integer, Integer> map = new HashMap<>(16);
    //
    //         for (int i = 0; i < nums.length; i++) {
    //             map.put(nums[i], i);
    //         }
    //
    //         for (int i = 0; i < nums.length; i++) {
    //             int diff = target - nums[i];
    //             if (map.containsKey(diff) && map.get(diff) != i) {
    //                 return new int[] {i, map.get(diff)};
    //             }
    //         }
    //
    //         throw new IllegalArgumentException("No two sum solution");
    //     }
    // }

    /**
    * describe: O(n^2)
    **/
    // class Solution1 {
    //     public int[] twoSum(int[] nums, int target) {
    //         for (int i = 0; i < nums.length; i++) {
    //             for (int j = i + 1; j < nums.length; j++) {
    //
    //                 int result = nums[i] + nums[j];
    //                 if (target == result) {
    //                     return new int[]{i, j};
    //                 }
    //             }
    //         }
    //
    //         throw new IllegalArgumentException("No two sum solution");
    //     }
    // }

    /**
     * 反人类的存在：
     * nums:[1, 4096], target:4096, 结果：[0, 1], 错误
     */
    // class Solution4 {
    //     public int[] twoSum(int[] nums, int target) {
    //         int n = 2048;
    //         int[] map = new int[n];
    //         int max = n - 1;
    //         for(int i = 0; i < nums.length; i++){
    //             int b = map[(target - nums[i]) & max];
    //             if (b != 0){
    //                 return new int[]{b - 1, i};
    //             }
    //             map[nums[i] & max] = i + 1;
    //         }
    //         return null;
    //
    //     }
    // }
}
