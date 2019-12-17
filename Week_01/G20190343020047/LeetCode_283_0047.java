/**
 * 解题思路：
 * int j指向第一个非零位置
 * 遍历数组找到非零元素与为0的j做交换
 */
public class Solution {
    public void moveZeroes(int[] nums){
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                nums[j] = nums[i];
                if (i!=j){
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
