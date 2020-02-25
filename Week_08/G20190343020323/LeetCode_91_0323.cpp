class Solution {
public:
	int numDecodings(string s) {
		size_t len = s.size();
		if (s.front() == '0') { return 0; }
		if (len == 1) { return 1; }
		vector<pair<int, int> > dp(len+1);
		dp[1] = {1, 1};
		for (size_t i = 2; i <= len; ++i) {
			string tmp = s.substr(i - 2, 2);
			if (tmp == "00") { return 0; }
			if (tmp[1] == '0') {
				if (26 < atoi(tmp.c_str())) { return 0; }
				else {
					dp[i].first = dp[i - 1].second;
					dp[i].second = -1;
				}
			}
			if (tmp[0] == '0') {
				dp[i].first = dp[i - 1].first;
				dp[i].second = dp[i].first;
			}
			else if(tmp[1] != '0' && tmp[0] != '0') {
				if (26 < atoi(tmp.c_str())) {
					dp[i].first = dp[i - 1].first;
					dp[i].second = dp[i].first;
				}
				else {
					dp[i].first = dp[i - 1].first + dp[i - 1].second;
					dp[i].second = dp[i - 1].first;
				}
			}
		}
		return dp.back().first;
	}
};