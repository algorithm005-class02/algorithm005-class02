class Solution {
public:
    // 双指针 只遍历一次数组O(n)
    int trap(vector<int>& height) {
        int water = 0;
        if (height.size() <= 2) return water;   // 特殊数组直接返回；
        int leftPtr = 0;    // 左指针 由左向右遍历，存放临时最大值
        int rightPtr = height.size() - 1;   // 右指针 由右向左遍历，存放临时最大值
        while (leftPtr != rightPtr) {   // 两指针相遇则遍历结束
            if (height[leftPtr] <= height[rightPtr]) {  // 从较小的边界开始向中间遍历
                int temp = height[leftPtr];
                while (leftPtr < rightPtr && height[leftPtr] <= temp) { // 遍历到低处则计算该处蓄水
                    water += temp - height[leftPtr];
                    leftPtr++;
                }
            }
            if (height[leftPtr] > height[rightPtr]) {
                int temp = height[rightPtr];
                while (leftPtr < rightPtr && height[rightPtr] <= temp) {
                    water += temp - height[rightPtr];
                    rightPtr--;
                }
            }
        }
        return water;
    }
};