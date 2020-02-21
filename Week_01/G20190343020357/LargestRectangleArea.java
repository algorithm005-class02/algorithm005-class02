package com.queue;

import java.util.Stack;

public class LargestRectangleArea {

    //暴力法
    public static int largestRectangleArea(int[] heights) {
        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            int leftHeight = heights[i];
            int minHeight = heights[i];
            for (int j = i; j < heights.length; j++) {
                int rightHeight = heights[j];
                minHeight = Math.min(minHeight, rightHeight);
                area = Math.max(area, minHeight * (j - i + 1));
            }
        }
        return area;
    }

    public static int largestRectangleArea1(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] *( heights.length - stack.peek() - 1));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int i = largestRectangleArea(heights);
        System.out.println();
    }
}
