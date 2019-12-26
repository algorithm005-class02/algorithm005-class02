class Solution {
public:
    Solution()
        : m_cList{{'2', "abc"}, {'3', "def"},  {'4', "ghi"}, {'5', "jkl"},
                  {'6', "mno"}, {'7', "pqrs"}, {'8', "tuv"}, {'9', "wxyz"}} {}
    ~Solution() {}
    Solution(const Solution& sol) { m_cList = sol.m_cList; }
    
    vector<string> letterCombinations(string digits) {
        if (!digits.size()) return vector<string>();
        vector<string> myRes;
        string posStr = "";
        LC_DC(0, posStr, digits, myRes);
        return myRes;
    }

private:
    unordered_map<char, string> m_cList;

    void LC_DC(int level, string posStr, string& digits, vector<string>& myRes) {
        if (level == digits.size()) {
            myRes.push_back(posStr);
            return;
        }
        for (int i = 0; i < m_cList[digits[level]].size(); i++) {
            posStr += m_cList[digits[level]][i];
            LC_DC(level + 1, posStr, digits, myRes);
            posStr.erase(posStr.size() - 1);
        }
    }
};