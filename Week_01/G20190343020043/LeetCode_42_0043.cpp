class Solution {
public:
    int trap(vector<int>& height) {
        int current = 0, top = 0;
        int ret = 0;
        stack<int> st;
        while (current < height.size()) {
            while (!st.empty() && height[current] > height[st.top()]) {
                top = st.top();
                st.pop();
                if(st.empty()) {
                    break;
                }
                ret += (min(height[current],height[st.top()]) - height[top]) * (current - st.top() -1);
            }
            st.push(current);
            current++;
        }
        return ret;
    }
};