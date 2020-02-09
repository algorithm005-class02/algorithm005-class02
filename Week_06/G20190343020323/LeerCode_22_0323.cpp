class Solution {
public:
    void helper(int left,int right,string s,vector<string> & result){
        if(left == 0 && right == 0){
            result.push_back(s);
            return;
        }
        if(left>0){
            helper(left-1,right,s+'(',result);
        }
        if(left < right){
            helper(left,right-1,s+')',result);
        }
    }
    vector<string> generateParenthesis(int n) {
        string s;
        vector<string> result;
        if(n == 0) return result;
        helper(n,n,s,result);
        return result;
    }
};