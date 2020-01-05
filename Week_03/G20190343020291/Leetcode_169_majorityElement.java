import java.util.Arrays;

/**
 * 众数
 * https://leetcode.com/problems/majority-element/
 */
public class Leetcode_169_majorityElement {
    /**
     * 数组排序后众数始终在数组中间的位置
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
