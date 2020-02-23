/**
 * 删除排序数组中的重复项
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class Leetcode_26_removeDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        for (; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
