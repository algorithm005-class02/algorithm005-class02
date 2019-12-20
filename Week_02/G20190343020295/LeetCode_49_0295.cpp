class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string,vector<string>> myMap; // 
        vector<vector<string>> res;
        for(auto str:strs){
            string tmp = str;
            sort(tmp.begin(),tmp.end());
            myMap[tmp].push_back(str);
        }
        for(const auto& m:myMap)
            res.push_back(m.second);
        return res;
    }
};