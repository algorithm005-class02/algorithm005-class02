class Solution {
public:
    // 哈希表
    bool isAnagram(string s, string t) {
        unordered_map<char, int> sMap;  // 字母为key，字母出现的次数为value
        if (t.size() != s.size()) return false;
        // sMap[s[i]]，该键值不存在时，会insert一个pair，这个pair的第二个参数调用默认构造函数，pair的int默认为0
        /*for (int i = 0; i < s.size(); i++) {  // 将每个字符放进map中
            if (sMap.find(s[i]) == sMap.end())
                sMap[s[i]] = 1;
            else
                sMap[s[i]]++;
        }
        for (int i = 0; i < t.size(); i++) {      // 逐个检查t中的字符
            if (sMap.find(t[i]) != sMap.end()) {  // 找到该字符
                sMap[t[i]]--;                     // 将map中的值减一
                if (sMap[t[i]] < 0)
                    return false;  // 若map中的值小于0，则返回false
            }
        }*/ // 以上部分改写为：
        for (int i = 0; i < s.size(); i++) {
            sMap[s[i]]++;
            sMap[t[i]]--;
        }

        for (unordered_map<char, int>::iterator it = sMap.begin();
             it != sMap.end(); it++)
            if (it->second) return false;
        return true;
    }
    // 数组仿哈希 //可能出现的字母只有26个
    bool isAnagram2(string s, string t) {
        if (s.length() != t.length()) return false;
        int n = s.length();
        int counts[26] = {0};
        for (int i = 0; i < n; i++) {
            counts[s[i] - 'a']++;   // char做加减法，ASCII码加减法
            counts[t[i] - 'a']--;
        }
        for (int i = 0; i < 26; i++)
            if (counts[i]) return false;
        return true;
    }
};
