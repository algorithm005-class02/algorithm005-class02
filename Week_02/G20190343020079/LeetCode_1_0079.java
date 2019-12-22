package com.star.l01;

import java.util.HashMap;
import java.util.Map;

/**
 * @author star
 * @Date 2019/12/21.
 * @Description: No Description Yet.
 */
public class Solution_1 {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] { map.get(complement), i };
      }
      map.put(nums[i], i);
    }
    return null;
  }
}