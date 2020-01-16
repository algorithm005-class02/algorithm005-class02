/*
 使用双指针：一个慢指针i，一个快指针j。
当nums[i]与nums[j]相等，快指针j后移1位;
当nums[i]与nums[j]不相等，赋值nums[i] = nums[j]，i后移1位；
重复上述过程，直到j等于数组的长度，返回i = 1。
*/
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.size(); j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
};

