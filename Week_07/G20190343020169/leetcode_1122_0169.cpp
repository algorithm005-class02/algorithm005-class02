class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        vector<int> v(1001, 0);
        for(int i = 0; i < arr1.size(); ++i){
            v[arr1[i]]++;
        }
        
        int c = 0;
        for(int i = 0; i < arr2.size(); ++i){
            for(int j = 0; j < v[arr2[i]]; ++j){
                arr1[c++] = arr2[i];
            }
            v[arr2[i]] = 0;
        }
        
        for(int i = 0; i < v.size(); i++){
            if(v[i] != 0){
                for(int k = 0; k < v[i]; ++k){
                    arr1[c++] = i;
                }
            }
        }

        return arr1;
    }
};
