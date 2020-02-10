class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
       map<int, int> m1, m2;
       for (auto & c : arr2) {
           m1[c] = 0;
       }

       for (auto & c : arr1) {
           auto iter = m1.find(c);
           if (iter != m1.end()) {
               iter->second++;
           }else{
               m2[c]++;
           }
       }

       vector<int> res;
       for (auto & c : arr2) {
            for (int i = 0; i < m1[c]; i++) {
               res.push_back(c);
           }
       }
       for (auto & c : m2) {
           for (int i = 0; i < c.second; i++) {
               res.push_back(c.first);
           }
       }
       return res;
    }
};