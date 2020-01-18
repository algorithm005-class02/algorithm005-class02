class Solution {
public:
	int findContentChildren(vector<int>& g, vector<int>& s) {
		sort(g.begin(), g.end());
		sort(s.begin(), s.end());
		int count = 0;
		for (int i = 0, j = 0; i<g.size() && j<s.size();) {
			if (s[j] >= g[i]) count++, i++, j++;
			else j++;
		}
		return count;
	}
};