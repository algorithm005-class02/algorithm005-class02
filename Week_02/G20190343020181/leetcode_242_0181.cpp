#include <string>
#include <map>
#include <unordered_map> 
#include <vector>

using namespace std;


//这种方法遇到长字符串执行会比较慢容易GG
class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size() ) return false;
        unordered_map<char, int> record_map;
        for (int i = 0; i < s.size(); i++)
        {
            auto iter = record_map.find(s[i]);
            if (iter != record_map.end())
            {
                iter->second++;
            }
            else
            {
                record_map[s[i]] = 1;
            }
        }

        for (int i = 0; i < t.size(); i++)
        {
            auto iter = record_map.find(t[i]);
            if (iter == record_map.end())
            {
                return false;
            }
            else
            {
                if (iter->second == 0) return false;
                iter->second--;
            }
        }

        return true;
    }
};

#include <unordered_map>
class Solution4 {
public:
 void add_record(unordered_map<int,int> &record_map, int num)
    {
        auto iter = record_map.find(num);
        if (iter == record_map.end())
        {
            record_map[num] = 1;
        }
        else
        {
            iter->second++;
        }
    }

    bool isAnagram(string s, string t) {
        if (s.size() != t.size()) return false;
        if (s.empty() == t.empty()) return true;
        unordered_map<int,int> record_map_s;
        unordered_map<int,int> record_map_t;
        for (int i = 0; i < s.size() ; i++)
        {
           add_record(record_map_s,s[i]);
           add_record(record_map_t,t[i]);
        }
        if (record_map_s != record_map_t) return false;

        return true;
    }

   
};

int main()
{
    Solution4 s;
    s.isAnagram("a","b");
    
    return 0;
}

class Solution2 {
public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size() ) return false;
        unordered_map<char, int> record_map;
        unordered_map<char, int> record_map2;
        for (int i = 0; i < s.size(); i++)
        {
            auto iter = record_map.find(s[i]);
            if (iter != record_map.end())
            {
                iter->second++;
            }
            else
            {
                record_map[s[i]] = 1;
            }
            auto iter2 = record_map2.find(t[i]);
            if (iter2 != record_map2.end())
            {
                iter2->second++;
            }
            else
            {
                record_map2[t[i]] = 1;
            }
        }

        if (record_map2 != record_map) return false;

        return true;
    }
};