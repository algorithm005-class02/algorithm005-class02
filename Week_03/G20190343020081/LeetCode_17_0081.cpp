class Solution {
public:
    vector<string> letterCombinations(string digits) {
        vector<string> ret;
        if(digits.size()==0)
            return {};
        else
            DFS("",digits, ret);
        return ret;
    }

private:
    void DFS(string cur,string next_digits, vector<string> &ret){
        map<char,string> digitmp = {{'2',"abc"},{'3',"def"},{'4',"ghi"},{'5',"jkl"},{'6',"mno"},{'7',"pqrs"},{'8',"tuv"},{'9',"wxyz"}};
        if (next_digits.size() == 0)
            ret.push_back(cur);
        else {
            char digit = next_digits[0];
            string letters = digitmp[digit];
            for(int i = 0; i < letters.size(); i++){
                string letter = letters.substr(i,1);
                DFS(cur+letter, next_digits.substr(1), ret);
            }
        }
    }
};

