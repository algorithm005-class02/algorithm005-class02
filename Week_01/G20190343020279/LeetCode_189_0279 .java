/**
 *@方法：“快慢双指针”  时间复杂度：O(n)
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        //判断数组是否空
        if (nums == null || nums.length == 0) return 0;
        //慢指针的下标（记录最后一个不重复的数字位置）
        int uniqne = 0;
        for (int i = 0; i < nums.length; i++) {
            //当遇到不重复的数字时
            if (nums[i] != nums[uniqne]) {
                //把当前不重复的数字覆盖到“新数组”后面(取原数组的前‘unique + 1’个数字组成概念上的新数组)，在赋值到新位置的同时unique自增指向新的最后一个不重复数字的位置。
                nums[++uniqne] = nums[i];
            }
        }
        //返回新数组长度
        return uniqne + 1;
    }
}