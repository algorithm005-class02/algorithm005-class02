class Solution {
public:
    int minDistance(string word1, string word2) {
        vector<vector<int>> db_vec(word1.size() + 1, vector<int> (word2.size() + 1, 0));

        for (int i = 0; i <= word1.size(); i++)
            db_vec[i][0] = i;
        for (int i = 0; i <= word2.size(); i++)
            db_vec[0][i] = i;
        
        for (int i = 1; i <= word1.size(); i++)
        {
             for (int j = 1; j <= word2.size(); j++) {
                if (word1[i - 1] == word2[j - 1]) 
                    db_vec[i][j] = db_vec[i - 1][j - 1];
                else
                    db_vec[i][j] = min(db_vec[i][j - 1], min(db_vec[i - 1][j - 1], db_vec[i - 1][j])) + 1;
            }
        }
        return db_vec.back().back();
    }
};