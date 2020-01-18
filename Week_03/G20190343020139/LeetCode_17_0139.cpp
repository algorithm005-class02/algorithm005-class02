/*
 * @lc app=leetcode.cn id=17 lang=cpp
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (51.57%)
 * Likes:    529
 * Dislikes: 0
 * Total Accepted:    66.9K
 * Total Submissions: 129K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * Your runtime beats 71.11 % of cpp submissions
 * Your memory usage beats 86.47 % of cpp submissions (8.4 MB)
 */

// @lc code=start
class Solution {
public:
    vector<string> result;
    map<char,string> m = {{'2',"abc"}, {'3',"def"}, {'4',"ghi"}, 
                              {'5',"jkl"}, {'6',"mno"}, {'7',"pqrs"}, 
                              {'8',"tuv"}, {'9',"wxyz"}};
    void backtrack(string comb, string digits){
        string temp = digits;
        if(digits.size() == 0){
            result.push_back(comb);
            
        }else {
            //string digits_cut = digits.erase(0,1);
            string letters;
            map<char, string>::iterator it;
            it = m.find(digits[0]);
            if(it != m.end()){
                letters = it->second;
            }
//            cout<<"letters:"<<letters<<endl;
            for(int i = 0; i < letters.size(); i++){
                char letter = letters[i];
//                cout<<"comb+letter:"<<comb<<letter<<endl;
                backtrack(comb+letter, digits.erase(0,1));
                digits = temp;
            }
        }
        return;
    }

    vector<string> letterCombinations(string digits) {

        int size = digits.size();
        if(size != 0)
            backtrack("",digits);
        return result;
    }

/*
    vector<string> letterCombinations(string digits) {
        vector<string> result;
        if(digits.empty()) return vector<string>();
        static const vector<string> v = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        result.push_back("");
        for(int i = 0; i <digits.size(); i++){
            int num = digits[i] - '0';
            if(num < 0 || num > 9) break;
            const string& a = v[num];
            if(a.empty()) continue;
            vector<string> temp;
            for(int j = 0; j < a.size(); j++){
                for(int k = 0; k < result.size(); k++){
                    temp.push_back(result[k]+a[j]);
                }
            }
            result.swap(temp);

        }
        return result;
    }
*/
};
// @lc code=end

