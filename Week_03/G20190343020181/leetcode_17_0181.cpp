#include <unordered_map>
#include <vector>
#include <string>
using namespace std;

#include <unordered_map>
class Solution {
public:
    vector<string> letterCombinations(string digits) {
        if (digits.empty()) return vector<string>();
        unordered_map<string, string> num_string_map;
        num_string_map.insert(make_pair("2","abc"));
        num_string_map.insert(make_pair("3","def"));
        num_string_map.insert(make_pair("4","ghi"));
        num_string_map.insert(make_pair("5","jkl"));
        num_string_map.insert(make_pair("6","mno"));
        num_string_map.insert(make_pair("7","pqrs"));
        num_string_map.insert(make_pair("8","tuv"));
        num_string_map.insert(make_pair("9","wxyz"));

        vector<string> num_vec;
        for (auto & c : digits)
        {
            string s ;
            s += c;
            num_vec.push_back(num_string_map[s]);
        }

        vector<string> res_vec;
        string s;
        getWord(num_vec, 0, s, res_vec);
        return res_vec;
    }

    void getWord(vector<string> &v1, int i, string s, vector<string> &res_vec)
    {
        if (i == v1.size())
        {
            res_vec.push_back(s);
            return;
        }

        for (auto & c : v1[i])
        {
            string tmp = s;
            tmp += c;
            getWord(v1, i + 1, tmp, res_vec);
        }
    }
};

int main()
{
    Solution s;

    s.letterCombinations("23");

    return 0;
}