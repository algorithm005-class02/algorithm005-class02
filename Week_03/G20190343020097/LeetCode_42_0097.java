package leetcode;

import java.util.Stack;

/**
 * * @author jiangli
 * * @date 2019/12/25 13:26
 * * @description trapping-rain-water 接雨水
 */
public class LeetCode_42_0097 {

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0;
        int right = height.length - 1;
        int left_max = 0;
        int right_max = 0;
        int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < left_max) {
                    res += left_max - height[left];
                } else {
                    left_max = height[left];
                }
                left++;
            } else {
                if (height[right] < right_max) {
                    res += right_max - height[right];
                } else {
                    right_max = height[right];
                }
                right--;
            }
        }
        return res;
    }

    public int trap2(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int currentIndex = 0;
        while (currentIndex < height.length) {
            while (!stack.isEmpty() && height[currentIndex] > height[stack.peek()]) {
                int h = height[stack.pop()];
                if (stack.empty()) {
                    break;
                }
                int distance = currentIndex - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[currentIndex]);
                sum = sum + distance * (min - h);
            }
            stack.push(currentIndex);
            currentIndex++;
        }
        return sum;
    }

    public int trap3(int[] height) {
        if (height == null || height.length == 0) return 0;
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                int h = height[stack.pop()];
                if (stack.isEmpty()) break;
                sum += (Math.min(height[i], height[stack.peek()]) - h) * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return sum;
    }
}
