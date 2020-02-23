/**
 * 乘积最大子序列
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class Leetcode_152_maximumProductSubarray {
    public int maxProduct(int[] nums) {
        int min = nums[0], max = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmpMax = nums[i] * max;
            int tmpMin = nums[i] * min;
            max = Math.max(Math.max(tmpMax, tmpMin), nums[i]);
            min = Math.min(Math.min(tmpMax, tmpMin), nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
