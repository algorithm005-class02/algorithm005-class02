/*
 * @lc app=leetcode.cn id=127 lang=cpp
 *
 * [127] 单词接龙
 *
 * https://leetcode-cn.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (38.21%)
 * Likes:    185
 * Dislikes: 0
 * Total Accepted:    18K
 * Total Submissions: 46.5K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord
 * 的最短转换序列的长度。转换需遵循如下规则：
 * 
 * 
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 
 * 
 * 说明:
 * 
 * 
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出: 5
 * 
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * ⁠    返回它的长度 5。
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * 输出: 0
 * 
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * 
 */

// @lc code=start


class Solution {
    /*
public:

    int checkWord(string a, string b){
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            if(a[i] == b[i]) continue;
            count++;
            if(count >= 2) break;
        }
        return count == 1;
    }
    int find_a_word(int count, string middleWord, vector<string> wordList, string endWord, int num){
        //terminator
        int n = wordList.size();
        int min = num+1;
        int ans = 0;
        int forward = 0;
        vector<string> tempList = wordList;
        string middle;
        if(count > num ) return 0;
        if(0 == middleWord.compare(endWord)) {
            return count < min ? count : min;
        };
        for(int i = 0; i < n; i++){
            wordList = tempList;
            if(!checkWord(middleWord,wordList[i])) continue;
            middle = wordList[i];
            wordList.erase(wordList.begin()+i);
            ans = find_a_word(count+1, middle, wordList ,endWord, num);
            min = (ans != 0 && ans < min) ? ans : min;
            forward = 1;

        }
        if(forward) return min;
        else return 0;

    }
    
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {

        int isthere = 0;
        int count = 0;
        if(beginWord.compare(endWord) == 0) return 1;
        
        for(int i = 0; i < wordList.size(); ){
            if(0 == beginWord.compare(wordList[i])) {
                wordList.erase(wordList.begin()+i);
                
            } else {
                if(0 == endWord.compare(wordList[i])) {
                    isthere = 1;
                }
                i++;
            }
        }
        cout<<isthere<<endl;
        if(isthere) {
            count = find_a_word(1, beginWord, wordList, endWord, wordList.size());
        }
        return count;
    }
    */
   /*
   int ladderLength(string beginWord, string endWord, vector<string>& wordList) 
{
	if (beginWord == endWord) return 1;
	bool flag = true;

	map<string, vector<string>> comboList;
	for (auto w : wordList)
	{
		if (w == endWord)
		{
			flag = false;
		}
		for (size_t i = 0; i < w.size(); i++)
		{
			auto temp = w;
			temp[i] = '*';
			comboList[temp].push_back(w);
		}
	}
	if (flag) return 0;

	unordered_map<string, int> vi[2];
	queue<string> que[2];
	que[0].push(beginWord);
	vi[0][beginWord] = 1;
	que[1].push(endWord);
	vi[1][endWord] = 1;

	while (!que[0].empty() || !que[1].empty())
	{
		int k = (que[0].size() < que[1].size()) ? 0 : 1;
		k = (que[k].size() == 0) ? (k + 1) % 2 : k;
		auto& qr = (que[0].size() < que[1].size()) ? que[0] : que[1];
		
		for (int i = que[k].size(); i > 0; i--)
		{
			auto q = que[k].front();
			que[k].pop();

			for (size_t i = 0; i < q.size(); i++)
			{
				auto temp = q;
				temp[i] = '*';

				for (auto w : comboList[temp])
				{
					if (vi[k].count(w) != 0) continue;
					int k2 = (k + 1) % 2;
					if (vi[k2].count(w) != 0)
					{
						return vi[k2][w] + vi[k][q];
					}

					que[k].push(w);
					vi[k][w] = vi[k][q] + 1;
				}
			}
		}
	}

	return 0;
}
*/
public:
    int ladderLength(string start, string end, vector<string>& bank) {
        if(start == end) return 1;
        if(start.empty()||end.empty()||bank.empty()) return 0;
        int found = 0;
        for(int i = 0; i < bank.size(); i++){
            if(end == bank[i]){
                found = 1;
                break;
            }
        }
        if(!found) return 0;
        return helper(start, end, bank);
        
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
    int helper(string start, string end, vector<string>& bank){

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
            }
        }
        return 0;
    }
};
// @lc code=end

