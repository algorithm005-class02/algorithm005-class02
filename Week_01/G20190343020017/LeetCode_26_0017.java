class Solution {
    // 1.课前尝试解题（之前已经做过这个题目看过题解）
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int slow = 0, fast = 0;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}