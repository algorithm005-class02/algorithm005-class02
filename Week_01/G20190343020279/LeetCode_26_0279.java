/**
 *@方法：“环状替换”  时间复杂度：O(n)
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        //每移动赋值一个数字后 + 1
        int count = 0;
        //第一小轮的下标
        int start = 0;
        //每个元素移动一次后完成
        for (; count < nums.length; start++) {
            //完成上一小轮的移动后提升一轮下标（前一轮第一个下标 + 1）

            //把差值加上后（1个下标位）添加到小循环内的第一个下标
            int current = start;
            //设置每一闭环的小圈的第一个移动数字（前一轮第一个 + 1）
            int prev = nums[start];
            do {
                //找到下一个要移动的位置下标
                int next = (current + k) % nums.length;
                //将下一次循环要用到的下一个要移动的数据暂时放到临时变量那里
                int temp = nums[next];
                //将上一个循环保存下来的要移动的数据现在覆盖到它应该在的地方
                nums[next] = prev;
                //将刚才放到临时变量那里的下一个要移动的数据放到prev变量里为下一次循环做准备
                prev = temp;
                //更新现在下标的位置
                current = next;
                count++;
            } while (start != current);
        }
    }
}
