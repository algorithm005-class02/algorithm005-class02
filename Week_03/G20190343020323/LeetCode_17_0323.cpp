class Solution {
public:
    vector<string> letterCombinations(string digits) {
        map<char, string> m = { {'2',"abc" },{'3',"def"},{'4',"ghi"},{'5',"jkl"},{'6',"mno"},{'7',"pqrs"},{'8',"tuv"},{'9',"wxyz"} };
        vector<string> result;
        if(digits.size() == 0){
            return result;
        }
        auto tempResult = letterCombinations(digits.substr(0,digits.size()-1));
        string flag = m[digits.at(digits.size()-1)];
        for(int i=0;i<flag.size();++i){
            char tempChar = flag.at(i);
            if(tempResult.size() == 0){
                result.push_back(string(1,tempChar));
            }else
            {
                for(auto k : tempResult){
                    result.push_back(k+tempChar);
                }
            }
        }
        return result;
    }
};