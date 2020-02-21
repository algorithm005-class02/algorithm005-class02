package leetcode.week03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 */
public class LeetCode_169_0069 {

   public static void main (String args[]) {
       int[] nums = {1,2,3,3,3,2,4,4,4,4,4,4};
       int res = majorityElment (nums);
       System.out.println("res :"+res);
   }

    /**
     * 找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素
     * @param nums
     * @return
     */
    private static int majorityElment(int[] nums) {
        //使用库函数 Arrays排序 time O(nlogn)
       Arrays.sort(nums);
       int len = nums.length;
       int res = nums [len / 2];
       return res;

        // for loop
//        int major = nums[0],count = 1;
//        for (int i = 1 ; i < nums.length ; i++) {
//            if (count == 0) {
//                 count ++;
//                 major = nums[i];
//            }else if (major == nums[i]) {
//                count ++;
//            }else count --;
//        }
//        return major;
    }
}
