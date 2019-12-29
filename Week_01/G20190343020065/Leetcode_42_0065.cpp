/* 栈解法
 * 总体思路：
 * 使用栈存储条形块索引下标
 * 遍历数组：
 *  1.当栈非空，且当前索引块高度 > 栈顶元素对应索引块高度时：
 *      pop栈顶元素
 *      计算当前元素与栈顶元素的距离distance
 *      找出界定高度：bounded_height
 *      计算积水量 = distance * bounded_height
 *      累加积水量
 *  2.将当前索引下标入栈
 *  3.当前索引向下移动1个位置。
 *
*/

class Solution {
public:
    int trap(vector<int>& height)
    {
        int ans = 0, current = 0;
        stack<int> st;
        while (current < height.size()) {
            while (!st.empty() && height[current] > height[st.top()]) {
                int top = st.top();
                st.pop();
                if (st.empty())
                    break;
                int distance = current - st.top() - 1;
                int bounded_height = min(height[current], height[st.top()]) - height[top];
                ans += distance * bounded_height;
            }
            st.push(current++);
        }
        return ans;
    }
}
