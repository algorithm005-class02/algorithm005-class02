/*
 * @lc app=leetcode.cn id=32 lang=cpp
 *
 * [32] 最长有效括号
 *
 * https://leetcode-cn.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (28.86%)
 * Likes:    456
 * Dislikes: 0
 * Total Accepted:    33.5K
 * Total Submissions: 115.2K
 * Testcase Example:  '"(()"'
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 
 * 示例 1:
 * 
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    int longestValidParentheses(string s) {
        int res = 0;
        int size = s.length();
        vector<int> dp(size, 0);
        for(int i = 1; i < size; i++){
            if(s[i]==')'){
                if(s[i-1]=='('){
                    dp[i] = ( (i >= 2) ? dp[i-2] : 0 ) + 2;
                } else if((i - dp[i - 1] > 0 && s[i - dp[i - 1] - 1] == '(') ){
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                res = res > dp[i] ? res : dp[i];
            }
        }
        return res;
    }
};
// @lc code=end

