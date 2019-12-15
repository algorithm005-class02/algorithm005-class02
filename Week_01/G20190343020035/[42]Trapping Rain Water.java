//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {

        int allWaterArea = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈
                if (stack.empty()) {
                    break;
                }
                int distance = current - stack.peek() - 1; /
                int min = Math.min(height[stack.peek()], height[current]);
                allWaterArea = allWaterArea + distance * (min - h);
            }
            stack.push(current); /
            current++;
        }
        return allWaterArea;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
