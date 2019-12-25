class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        map<string, vector<string>> smap;
        for(auto it: strs) {
            string key = getKey(it);
            smap[key].push_back(it);
        }

        vector<vector<string>> ret;
        for(auto it: smap)
            ret.push_back(it.second);
        return ret;
    }
private:
    string getKey(string& str){
        vector<int> feq(26, 0);
        for(auto it: str) 
            feq[it-'a']++;
            
        string key = "";
        for(auto it: feq)
            key += to_string(it) + "#";
        return key;
    }
};
