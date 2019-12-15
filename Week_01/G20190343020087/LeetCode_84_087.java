import java.util.Stack;

import javax.print.DocFlavor.READER;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 * 
 * 1.暴力破解
 *     public int largestRectangleArea(int[] heights) {
        int maxarea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minheight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                minheight = Math.min(minheight, heights[j]);
                maxarea = Math.max(maxarea, minheight * (j - i + 1));
            }
        }
        return maxarea;
    }

    2.维护一个栈
    通过入栈从小到大的顺序来确定一根柱子的左右边界
    先入栈一个-1占位，一根柱子能构成的最大面积的公式为 :(i - st.peek() - 1) * st.pop()
    如图2入栈，1比2小，弹出1，就可以确定2的边界就是在1这根柱子，第一个为2的柱子所能构成的最大面积就为2*1
    之后继续入栈：1-5-6 遇到第二个2时出栈6 这时 6这根柱子左右边界确定了，能构成的最大面积为6*1
    2还是比5小，又弹出5，此时5的左右边界确定，最大面积5*2
    继续入栈1-2-3 入栈到此数组就遍历完了，最后依次弹出栈中剩余的顺序柱子3-2-1，并计算其面积大小
    最终max_a   rea中保存的面积就为该柱状图中能勾勒出的最大面积
 */

// @lc code=start
public class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack<>();
        st.push(-1); // 先入栈一个-1
        int max_area = 0; // 设置最大面积变量
        for (int i = 0; i < heights.length; ++i) {
            // 当栈顶部不为-1，并且大于等于下一柱子的高度时出栈，并计算面积
            while (st.peek() != -1 && heights[st.peek()] >= heights[i]) {
                // 计算出栈柱子的最大面积
                max_area = Math.max(max_area, heights[st.pop()] * (i - st.peek() - 1));
            }
            st.push(i); // 入栈i
        }
        // 出栈并计算栈内剩余的顺序排列的柱子能够成的面积
        while (st.peek() != -1) {
            max_area = Math.max(max_area, heights[st.pop()] * (heights.length - st.peek() - 1));
        }
        return max_area;
    }
}
// @lc code=end
