class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> wordDic(wordList.begin(), wordList.end());
        if (wordDic.count(endWord) == 0) {
            return 0;
        }

        unordered_map<string, int> convertLen = {{beginWord, 1}};
        queue<string> wordQueue{{beginWord}};
        while (!wordQueue.empty()) {
            string word = wordQueue.front();
            wordQueue.pop();
            for (int i = 0; i < word.size(); ++i) {
                string newWord = word;
                for (char ch = 'a'; ch <= 'z'; ++ch) {
                    newWord[i] = ch;
                    if (wordDic.count(newWord) > 0 && newWord == endWord) {
                        return convertLen[word] + 1;
                    }

                    if (wordDic.count(newWord) > 0 && !convertLen.count(newWord)) {
                        wordQueue.push(newWord);
                        convertLen[newWord] = convertLen[word] + 1;
                    }
                }
            }
        }
        return 0;
    }
};
