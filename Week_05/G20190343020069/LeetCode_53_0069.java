package leetcode.week05;

public class LeetCode_53_0069 {

    public static void main (String args[]) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    /**
     *找到一个具有最大和的连续子数组
     * （子数组最少包含一个元素），返回其最大和
     * @param nums
     * @return
     */
    public static int maxSubArray (int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i-1] > 0) {
                nums[i] += nums[i-1];
            }
            maxSum = Math.max(nums[i] , maxSum);
        }
        return maxSum;
    }
}
