//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子
// 下雨之后能接多少雨水。

// Related Topics 栈 数组 双指针

//leetcode submit region begin(Prohibit modification and deletion)
import org.junit.Test;

import java.util.Stack;

 public class LeetCode_42_0035 {

    public int trap(int[] height) {
        int allWaterArea = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop();
                if (stack.empty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                allWaterArea = allWaterArea + distance * (min - h);
            }
            stack.push(current);
            current++;
        }
        return allWaterArea;

    }

    @Test
    public void t1(){
        trap(new int[]{1,2,3});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
