/*
 * @lc app=leetcode.cn id=32 lang=cpp
 *
 * [32] 最长有效括号
 */

// @lc code=start
#include<string>
#include<vector>
#include<stack>

using namespace std;

class Solution {
public:
    int longestValidParentheses(string s) {
        int n = s.size();
        stack<int> st;
        int cur_max = 0;
        for(int i = 0; i < n; ++i){
            if(s[i] == '('){
                st.push(i);
            }else{
                if(!st.empty()){
                    int k = st.top();
                    if(s[k] == '(') st.pop();
                    else{ st.push(i);}
                }else{
                    st.push(i);
                }       
            }
        }
        if(st.empty()) cur_max = n;
        int b = 0, a = n;
        while(!st.empty()){
            int b = st.top();
            st.pop();
            cur_max = std::max(cur_max, a - 1 - b);
            a = b;
        }
        cur_max = std::max(a, cur_max);
        return cur_max;
    }

    int longestValidParentheses1(string s) {
        int n = s.size();
        vector<int> longest(n,0);
        int cur_max = 0;
        for(int i = 0; i < n; ++i){
            if(s[i] == ')'){
                  if(i - 1 >= 0 && s[i-1] == '('){
                      longest[i] = i-2 >= 0 ? longest[i-2] + 2 : 2;
                      cur_max = std::max(cur_max,longest[i]);
                  }else{
                      if(i-1 >= 0 && i-longest[i-1] - 1 >= 0 && s[i-longest[i-1] - 1] == '('){
                         longest[i] = i-longest[i-1]-2 >=0 ? longest[i-1] + 2 + longest[i-longest[i-1]-2]:longest[i-1] + 2;
                      }
                      cur_max = std::max(cur_max, longest[i]);
                  }
            }
        }
        return cur_max;
    }
};
// @lc code=end


