class Solution {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        if(matrix.size() == 0) return 0;
        vector<int> heights(matrix[0].size());
        int max_area = INT_MIN;
        for(int i = 0; i < matrix.size(); ++i){
            for(int j = 0; j < matrix[0].size(); ++j){
                if(matrix[i][j] == '1'){
                    heights[j] = heights[j] + 1;
                }else{
                    heights[j] = 0;
                }
            }
            max_area = std::max(max_area, largestRectangleArea(heights));
        }
        return max_area;
    }

    int largestRectangleArea(vector<int>& heights) {
        stack<int> s;
        s.push(-1);
        int max_area = 0;
        for(int i = 0; i < heights.size(); ++i){
            while(s.top() != -1 && heights[i] < heights[s.top()]){
                int t =  s.top();
                s.pop();
                max_area = std::max(max_area, (i - s.top() - 1) * heights[t]);
            }
            s.push(i);
        }
        while(s.top() != -1){
            int t = s.top();
            s.pop();
            int max = (heights.size() - s.top() - 1) * heights[t];
            if(max > max_area){
                max_area = max;
            }
        }
        return max_area;
    }
};
