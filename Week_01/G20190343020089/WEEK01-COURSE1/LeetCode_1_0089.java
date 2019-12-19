import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    // 双重循环解法
    // public int[] twoSum(int[] nums, int target) {
    //     int[] res = new int[2];
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = i+1; j < nums.length; j++) {
    //             if (nums[i] + nums[j] == target) {
    //                 res[0] = i;
    //                 res[1] = j;
    //                 break;
    //             }
    //         }
    //     }
    //     return res;
    // }

    // 放hash 表 O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer numInMap = numsMap.get(target - nums[i]);
            if (numInMap != null && i != numInMap) {
                if (i > numInMap) {
                    res[0] = numInMap;
                    res[1] = i;
                } else {
                    res[1] = numInMap;
                    res[0] = i;
                }
                break;
            }
        }
        return res; 
    }
}
// @lc code=end

