class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> res_vec;
        if (intervals.empty()) return res_vec;
        map<int, int> map_set;
        for (auto & gather : intervals) {
           auto iter = map_set.find(gather[0]);
           if (iter != map_set.end()) {
               iter->second = gather[1] > iter->second ? gather[1] : iter->second;
           }else{
               map_set[gather[0]] = gather[1];
           }
        }
        int s = map_set.begin()->first, b = map_set.begin()->second;
        for (auto & gather : map_set) {
            if (b >= gather.first)  {
                b = gather.second > b ? gather.second : b;
            }else {
                vector<int> vec = {s, b};
                res_vec.push_back(vec);
                s = gather.first;
                b = gather.second;
            }
        }
        vector<int> vec = {s, b};
        res_vec.push_back(vec);
        return res_vec;
    }
};