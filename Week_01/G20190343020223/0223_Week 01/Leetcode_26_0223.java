import sun.security.util.Length;

/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0; //记录每一次比较的不同数值元素出现的首下标
        int delete_length = 0;  //记录重复的元素个数，也就是要删除的长度；
        int counts = 0; //记录（跟踪）新生成的数组的下标递进
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[index] == nums[i]) {

                delete_length++;
                /*if ：判断一种特殊情况：原数组的最后一直是相等的情况，则将最后的一个元素值
                ，同样也是当前相等的数字序列的第一个元素放进新的数组 */
                if (i == nums.length - 1) { 
                    nums[counts] = nums[index];
                }
            } else {
                nums[counts] = nums[index];
                counts++;
                index = i;
                /* if判断一种特殊情况：最后一个元素与倒数第二个元素不相等，则将最后一个元素放
                进新的数组 */
                if (index == nums.length - 1) {
                    nums[counts] = nums[index];
                }
            }
        }
        return nums.length - delete_length;//返回的是输出：即新生成的数组的长度
    }
}
// @lc code=end
