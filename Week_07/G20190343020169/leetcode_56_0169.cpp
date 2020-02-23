class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> res;
        if(intervals.empty()) return res;
        sort(intervals.begin(), intervals.end(), [](vector<int> a, vector<int> b){
             return a[0] < b[0];
        });
        res.push_back(intervals[0]);
        for(int i = 1; i < intervals.size(); ++i){
            if(res.back()[1] < intervals[i][0]) res.push_back(intervals[i]);
            else{
                if(res.back()[1] < intervals[i][1]){
                    res.back().erase(res.back().begin() + 1);
                    res.back().push_back(intervals[i][1]);
                }
            }
        }
        return res;
    }

    vector<vector<int>> merge1(vector<vector<int>>& intervals) {
        vector<vector<int>> res;
        if(intervals.empty()) return res;
        sort(intervals.begin(), intervals.end(), [](vector<int> a, vector<int> b){
             return a[0] < b[0];
        });
        res.push_back(intervals[0]);
        for(int i = 1; i < intervals.size(); ++i){
            if(res.back()[1] < intervals[i][0]) res.push_back(intervals[i]);
            else{
                vector<int> back;
                back.push_back(res.back()[0]);
                back.push_back(std::max(res.back()[1],intervals[i][1]));
                res.pop_back();
                res.push_back(back);
            }
        }
        return res;
    }
};
