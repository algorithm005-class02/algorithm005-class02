#include <unordered_set>
#include <unordered_map>
#include <vector>
#include <string>
#include <deque>
using namespace std;



//自己写的超时了
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> word_set;
        bool in_word_set = false;
        for (auto & s : wordList)
        {
           word_set.insert(s);
           if (!in_word_set && s == endWord)
           in_word_set = true;
        }
        if (!in_word_set) return 0;
        unordered_set<string> already_word;
        return getNum(beginWord, endWord, word_set, 1, already_word);
    }

    int getNum(string beginWord, string endWord, 
    unordered_set<string> & word_set, int  level,
     unordered_set<string> already_word)
    {
        already_word.insert(beginWord);
        if (beginWord == endWord) return level;
        vector<string> next_vec;
        for (auto & s : word_set)
        {
            int count = 0;
            for (int i = 0; i < beginWord.size(); i++)
            {
                if (s[i] != beginWord[i]) count++;
                if (count > 1) break;
            }
            if (count == 1 && already_word.find(s) == already_word.end())
            {
                next_vec.push_back(s);
            }
        }
 
        int min_level = 0;
        for (auto & word : next_vec)
        {
            int l = getNum(word, endWord, word_set, level+1,already_word);
            if (l != 0 && (min_level == 0 || l < min_level))
            {
               min_level = l;
            }
        }
        return min_level;
    }
};

//大神写的
class Solution2 {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_map<string , vector<string> > grap;
        unordered_map<string, int> dist;
        unordered_map<string, bool> visited;
        deque<string> q;
        wordList.push_back(beginWord);
        for (int i = 0; i < wordList.size(); i++)
        {
            for (int j = i + 1; j < wordList.size(); j++)
            {
                if (check(wordList[i], wordList[j]))
                {
                    grap[wordList[i]].push_back(wordList[j]);
                    grap[wordList[j]].push_back(wordList[i]);
                }
            }
            visited[wordList[i]] = false;
        }
        
        q.push_back(beginWord);
        dist[beginWord] = 0;
        visited[beginWord] = true;

        while (!q.empty())
        {
            string cur_word = q.front();
            q.pop_front();
            for (auto & s : grap[cur_word])
            {
                if (!visited[s])
                {
                    dist[s] = dist[cur_word] + 1;
                    if (s == endWord) return dist[s];
                    q.push_back(s);
                    visited[s] = true;
                }
            }
        }

        return 0;
    }

    bool check(string str1, string str2)
    {
        bool res = false;
        for (int i = 0; i < str1.size(); i++)
        {
            if (str1[i] != str2[i])
            if (res)
            {
                return false;
            }
            else
            {
               res = true;
            }
        }
        return res;
    }
};


int main()
{
    Solution2 s;
   // vector<string>  word_list {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
    vector<string> word_list;
    word_list.push_back("hot");
    word_list.push_back("dot");
    word_list.push_back("dog");
    word_list.push_back("lot");
    word_list.push_back("log");
    word_list.push_back("cog");
    s.ladderLength("hit","cog",word_list);
}