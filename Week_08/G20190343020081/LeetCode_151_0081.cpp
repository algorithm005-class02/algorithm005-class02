class Solution {
public:
    string reverseWords(string s) {
        reverse(s.begin(), s.end());
        int start = 0, end = s.size() - 1;
        int left =0, right = 0;
        while(start <= end && s[start] == ' ') { start ++; }
        while(end >= start && s[end] == ' ') { end --; }
        for (right = start; right <= end; ) {
            while (s[right] == ' ' && right <= end) right ++;
            left = right;
            while (s[right] != ' ' && right <= end) right ++;
            reverse(s.begin() + left, s.begin() + right);
        }

        left = start;
        right = start;
        for (int i = left; i <= end; i++) {
            if (i > 1 && s[i] == ' ' && s[i - 1] == ' ') continue;
            s[right++] = s[i];
        }
        return s.substr(left, right - left);
    }
};
