/*
 * @lc app=leetcode.cn id=22 lang=cpp
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (72.47%)
 * Likes:    715
 * Dislikes: 0
 * Total Accepted:    69.1K
 * Total Submissions: 94.6K
 * Testcase Example:  '3'
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    vector<string> res;
    vector<string> generateParenthesis(int n) {
        helper("(", 1,0,n);
        return res;
    }
private:
    void helper(string s, int left, int right, int n){
        //terminator
        if(left == n && right == n) {
            res.push_back(s);
            return;
        }

        if(left == n){
            helper(s + ")", left, right+1, n);
        }else if(right < left){
            helper(s + "(", left + 1, right, n);
            helper(s + ")", left, right + 1, n);
        }else if(left == right){
            helper(s + "(", left + 1, right, n);
        }
    }
};
// @lc code=end

