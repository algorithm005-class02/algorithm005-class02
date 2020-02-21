class Solution {
public:
    string reverseStr(string s, int k) {
        int len = s.size();
        int i = 0;
        while (i < len) {
            reverse(s.begin() + i, s.begin() + (i + k <= len ? i + k : len));
            i += 2*k;
        }
        return s;
    }
};
