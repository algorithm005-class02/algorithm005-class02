class Solution {
public:
    string reverseWords(string s) {
        int start = 0;
        int end = s.size() - 1;
        for ( int right = start; right <= end; ) {
            while(right <= end && s[right] == ' ') right ++;
            int left = right;
            while(right <= end && s[right] != ' ') right ++;
            reverse(s.begin() + left, s.begin() + right);
        }
        return s;
    }
};
