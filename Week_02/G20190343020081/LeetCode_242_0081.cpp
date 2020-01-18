class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size() != t.size()) return false;
        bool ret = true;
        unordered_map<char, int> cmap;
        for(int i=0; i<s.size(); i++) {
            cmap[s[i]]++;
            cmap[t[i]]--;
        }
      
        for(int i=0; i<cmap.size(); i++) {
            if(cmap[i] != 0) {
                ret = false;
                break;
            }
        }
        return ret;
    }
};
