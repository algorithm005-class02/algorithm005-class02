package org.crayzer.leetcode.editor.en.分治_回溯;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 求众数
 * 给定一个大小为 n 的数组，找到其中的多数元素。
 * 多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 */
public class LeetCode_169_MajorityElement {

    class Solution3 {
        public int majorityElement(int[] nums) {
            return majRec(nums, 0, nums.length - 1);
        }

        private int majRec(int[] nums, int l, int r) {
            if (l == r) return nums[r];
            int mid = l + (r - l) / 2;
            int mElemLeft = majRec(nums, l, mid);
            int mElemRight = majRec(nums, mid + 1, r);

            if (checkMajority(nums, mElemLeft)) return mElemLeft;
            if (checkMajority(nums, mElemRight)) return mElemRight;
            return 0;
        }

        private boolean checkMajority(int[] nums, int n) {
            int count = 0;
            for (int num : nums) if (num == n) count++;
            return count > nums.length / 2;
        }
    }

    class Solution2 {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>(16);
            int maxNum = 0, maxCount = 0;

            for (int num : nums) {
                int count = map.getOrDefault(num, 0) + 1;
                map.put(num, count);
                if (count > maxCount) {
                    maxCount = count;
                    maxNum = num;
                }
            }
            return maxNum;
        }
    }

    class Solution1 {
        public int majorityElement(int[] nums) {
            int major = nums[0], count = 0;
            for (int i = 1; i < nums.length; i++) {
                if (major == nums[i]) {
                    count++;
                } else if (count == 0) {
                    major = nums[i];
                    count++;
                } else {
                    count--;
                }
            }

            return major;
        }
    }

    class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }
}
