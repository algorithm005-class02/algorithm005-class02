class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if(nums.empty()) return;
        if(k >= nums.size()) k = k%nums.size();
        reverse(nums, 0, nums.size()-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.size()-1);
        return;
    }
private:
    void reverse(vector<int>& nums, int i, int j) {
          for(; i<j; i++,j--) {
              swap(nums[i], nums[j]);
          } 
          return;
    }
};
