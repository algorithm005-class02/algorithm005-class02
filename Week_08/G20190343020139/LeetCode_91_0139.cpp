/*
 * @lc app=leetcode.cn id=91 lang=cpp
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (22.80%)
 * Likes:    280
 * Dislikes: 0
 * Total Accepted:    31.5K
 * Total Submissions: 136.5K
 * Testcase Example:  '"12"'
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 
 * 示例 1:
 * 
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    int numDecodings(string s) {
        if(s.length() == 0) return 0;
        if(s[0] == '0') return 0;
        if(s.length() == 1) return 1;
        int f[3];
        f[1] = 1;
        f[2] = 1;
        for(int i = 1; i < s.length(); i++){
            f[0] = f[1];
            f[1] = f[2];
            if(s[i] == '0'){
                f[2] = 0;
            }
            int tmp = (s[i-1] - '0')*10 + (s[i] - '0');
            if(tmp > 9 && tmp < 27) f[2] += f[0];
        }
        return f[2];
    }
};
// @lc code=end

