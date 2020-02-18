class Solution {
public:
    int firstUniqChar(string s) {
        unordered_map<char, int> smap;
        
        for (auto c: s) {
            smap[c] ++;
        }
        
        for (int i = 0; i < s.size(); i++) {
            if (smap[s[i]] == 1) {
                return i;
            }
        }
        
        return -1;
    }
};
