#include <unordered_map>
class Solution {
public:
    int firstUniqChar(string s) {
        unordered_map<char, int> map_cnt;
        for (auto c : s) {
            map_cnt[c]++;
        }
        for (int i = 0; i < s.size(); i++) {
            if (map_cnt[s[i]] == 1) 
                return i;
        }
        return -1;
    }
};