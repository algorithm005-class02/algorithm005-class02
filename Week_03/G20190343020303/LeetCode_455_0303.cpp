class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        int count = 0;
        sort(g.begin(), g.end(), greater<int>());
        sort(s.begin(), s.end(), greater<int>());
        for (int i = 0; i < g.size() && count < s.size(); i++)
            if (g[i] <= s[count])
                count++;
        return count;
    }
};
