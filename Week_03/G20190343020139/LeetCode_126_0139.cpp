/*
 * @lc app=leetcode.cn id=126 lang=cpp
 *
 * [126] 单词接龙 II
 *
 * https://leetcode-cn.com/problems/word-ladder-ii/description/
 *
 * algorithms
 * Hard (29.76%)
 * Likes:    102
 * Dislikes: 0
 * Total Accepted:    5.6K
 * Total Submissions: 17.9K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord
 * 的最短转换序列。转换需遵循如下规则：
 * 
 * 
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 
 * 
 * 说明:
 * 
 * 
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出:
 * [
 * ⁠ ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * 输出: []
 * 
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 * 
 */

// @lc code=start
/*
class Solution {
public:

    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        vector<vector<string>> res;
        vector<int> visited(wordList.size(),0);
        vector<string> bank = wordList;
        if(wordList.empty()) return res;
        int found = 0;
        int depth = 0;
        vector<string> path(1,beginWord);
        for(int i = 0; i < wordList.size(); i++){
            if(endWord == wordList[i]){
                found = 1;
                break;
            }
        }
        if(!found) return res;
        depth = bfs(beginWord, endWord, bank);
        cout<<"depth: "<<depth<<endl;
        dfs(beginWord, endWord, wordList, res, path, visited, depth, 1);
        return res;
        
    }
private:
    int is_single_change(string x, string y){
        int n = x.length();
        int diff = 0;
        for(int i = 0; i < n; i ++){
            if(x.at(i) != y.at(i)) diff++;
        }
        return diff == 1 ? 1 : 0;
    }
    void dfs(string start, string end, vector<string>& bank, vector<vector<string>> &res, vector<string>& path, vector<int> visited, int depth, int level){
        if(start == end && depth == level){
            res.push_back(path);
            return;
        }
        vector<string> local_path;
        if(level < depth){
            for(int i = 0 ; i < bank.size(); i++){
                if(visited[i] == 1) continue;
                if(is_single_change(start, bank[i])){
                    local_path = path;
                    local_path.push_back(bank[i]);
                    visited[i] = 1;
                    dfs(bank[i],end,bank,res,local_path,visited, depth, level+1);
                }
            }
        }

    }
    int bfs(string start, string end, vector<string>& bank){

        vector<int> visited(bank.size(),0);
        queue<string> q;
        string s;
        int level = 1;
        int cur_level = 1;
        int nxt_level = 0;
        q.push(start);
        while(!q.empty()){
            s = q.front();
            q.pop();      
            cur_level --;     
            for(int i = 0; i < bank.size(); i++){
                if(visited[i] == 0 && is_single_change(s, bank[i])){
                    if(bank[i] == end) return level+1;
                    visited[i] = 1;
                    q.push(bank[i]);
                    nxt_level++;
                }
            }
            if(cur_level == 0)
            {
                level ++;
                cur_level = nxt_level;
                nxt_level = 0;
                for(int i = bank.size()-1; i >= 0; i --) {
                    if(visited[i] == 1) {
                        visited[i] = 0;
                        bank.erase(bank.begin()+i);

                    }
                }
            }
        }
        return 0;
    }
    
};
*/
class Solution {
private:
    unordered_set<string> wordList;
    vector<vector<string>> ans;
    unordered_set<string> visited;
            
    int level = 1;
    int minLevel = INT_MAX;
    
public:
    vector<vector<string>> findLadders(string beginWord, string endWord,vector<string> &words ) {

        //Putting all words in a set
        for(auto word: words)
            wordList.insert(word);
        //wordList.insert(endWord); Cant insert endWord now
            
        //Queue of Paths
        queue<vector<string>> q;
        q.push({beginWord});
        

        while (!q.empty()) 
        {
            vector<string> path = q.front(); q.pop();
            
            if (path.size() > level)
            {
                //reach a new level
                for (string w : visited) 
                    wordList.erase(w);
                
                //visited.clear();
                if (path.size() > minLevel)
                    break;
                else
                    level = path.size();
            }
            
            
            string lastWord = path.back();
            
            addNeighboursToQ(lastWord,path,q,endWord);
        }
        
        return ans;
    }
    
    void addNeighboursToQ(string curr,vector<string> path,queue<vector<string>> &q,const string &endWord)
    {
            for(int i=0;i<curr.size();i++) 
            {
                char originalChar = curr[i];

                for(int j=0;j<26;j++)
                {
                    curr[i] = j + 'a';
                    
                    if(wordList.find(curr)!=wordList.end())
                    {
                        //cout<<curr<<"   added"<<endl;
                        vector<string> newpath = path;
                        newpath.push_back(curr);
                        
                        visited.insert(curr);
                        
                        
                        if (curr == endWord) {
                            minLevel = level;
                            ans.push_back(newpath);
                        }
                        else
                            q.push(newpath);
                        
                    }
                }
                
                curr[i] = originalChar;
            }//i
    }
};
// @lc code=end

