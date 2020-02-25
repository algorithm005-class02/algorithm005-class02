package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * * @author jiangli
 * * @date 2019/12/25 15:53
 * * @description majority-element 多数元素
 */
public class LeetCode_169_0097 {

    /**
     * 哈希表
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int maxNum = 0;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = 1;
            if (map.containsKey(num)) {
                count = map.get(num);
                map.put(num, ++count);
            } else {
                map.put(num, count);
            }
            if (count > maxCount) {
                maxCount = count;
                maxNum = num;
            }
        }
        return maxNum;
    }

    /**
     * 排序
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 摩尔投票
     *
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0;
        int group = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                group = nums[i];
            }
            count = group == nums[i] ? count + 1 : count - 1;
        }
        return group;
    }

}
