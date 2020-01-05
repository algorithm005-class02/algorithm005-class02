/**
 * 执行用时 :20 ms, 在所有 cpp 提交中击败了79.85%的用户
 * 内存消耗 :11.2 MB, 在所有 cpp 提交中击败了62.17%的用户
 * 必须使用引用，否则超出内存限制
*/

class Solution {
public:
    int cal_count(vector<int>& nums, int num, int start, int end){
        int count = 0;
        for(int i = start; i <= end; i ++){
            if(nums[i] == num) count ++;
        }
        return count;
    }

    int majorityElement(vector<int>& nums) {
        return getmajority(nums, 0 ,nums.size()-1);
    }

    int getmajority(vector<int> &nums, int start, int end ){
        if(start == end) return nums[start];
        int mid = ( start + end ) / 2;
        int left = getmajority(nums, start , mid);
        int right = getmajority(nums, mid+1, end);

        if(left == right) return left;
        int leftcount = cal_count(nums, left, start, end);
        int rightcount = cal_count(nums, right, start, end);
        return leftcount > rightcount ? left : right;
    }

};