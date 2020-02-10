class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> res(num + 1, 0);
        for (int i = 0; i <= num; i++)
            if ((i & 1) == 1)
                res[i] = res[i >> 1] + 1;
            else
                res[i] = res[i >> 1];
        return res;
    }
};