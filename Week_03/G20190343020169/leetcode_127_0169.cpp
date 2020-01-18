/*
 * @lc app=leetcode.cn id=127 lang=cpp
 *
 * [127] 单词接龙
 */

// @lc code=start

#include<string>
#include<vector>
#include<map>
#include<queue>

using namespace std;

class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
         map<string,int> m;
         map<string,bool> visited;
         map<string,vector<string>> combines;
         m[beginWord] = 1;
         for(auto &word : wordList){
             int L = word.size();
             for(int i = 0;i < L;++i){
                 string newWord = word.substr(0,i) + "*" + word.substr(i+1,L-i-1);
                 if(combines.count(newWord) > 0){
                     combines[newWord].push_back(word);
                 }else{
                     combines[newWord] = {};
                     combines[newWord].push_back(word);
                 }
             }
         }
         queue<string> queue;
         queue.push(beginWord);
         while(!queue.empty()){
             string word = queue.front();
             queue.pop();
             int level = m[word];
             int L = word.size();
             for(int i = 0; i < L; i++){
                 string newWord = word.substr(0,i) + "*" + word.substr(i+1,L-i-1);
                 vector<string> combinesv = combines[newWord];
                 for(auto &combine : combinesv){
                     if(!visited[combine]){
                        visited[combine] = true;
                        if(combine == endWord){
                            return level + 1;
                        }
                        if(m.count(combine) == 0){
                            m[combine] = level + 1;
                            queue.push(combine);
                        }
                     }
                 }
             }
         }
         return 0;
    }
