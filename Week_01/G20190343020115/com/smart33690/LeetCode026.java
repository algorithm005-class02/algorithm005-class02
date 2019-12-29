package com.smart33690;

/**
 * @Author: Smart
 * @Date: 2019/12/15 19:51
 */

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 */

public class LeetCode026 {
    public static void main(String[] args) {

    }
    public int removeDuplicates(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        //慢指针
        int i = 0;
        //j 快指针
        for (int j=0; j<nums.length; j++){
            //如果两个指针的数据不同，将快指针指向数据，放到慢指针后边
            //然后慢指针指向这个数据，快指针继续向前寻数
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }
}
