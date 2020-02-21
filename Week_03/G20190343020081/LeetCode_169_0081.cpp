class Solution {
public:
    int majorityElement(vector<int>& nums) {
      int target = nums[0];
      int sum = 1;
      for (int i = 1; i < nums.size(); i ++) {
          if (target != nums[i]) {
            sum--;
            if(sum == 0) {
                target = nums[i];
                sum = 1;
            }
          } else
            sum++;
      }
      return target;
    }
};
