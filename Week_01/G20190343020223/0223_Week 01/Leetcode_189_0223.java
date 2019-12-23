/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        k= k % nums.length;//必须要取余数组的长度，对应着特殊的样例 
        //数组只有一个元素【-1】 k=2;
        //但是需要移动两位的话，贸然的直接进行下述反转时，会出现数组越界的异常报出。
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    public void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
// @lc code=end
/* 
思路1：
一个不错的方法就是反转数组，可以做到O（1）的空间复杂度，不需要另外开辟数组空间
定义一个reverse函数；参数是（int[] num,int start,int end）将下标位置从start到end位置处
的数组元素反转一下

思路2：将原先数组中的元素按照：新下标=（下标+k）% 数组长度，进行新的一轮移动变换，但是得需要
开辟一个新的等长得数组来装载，如果中途赋值变化，会迷失元素 code如下：
        int save[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            save[(i + k) % nums.length] = nums[i];
        }
        for (int j=0;j<nums.length;j++){
            nums[j]=save[j];
        }

*/
