class Solution {
public:
    int search(vector<int>& nums, int target) {
        if(nums.size() == 0) {
            return -1;
        }
        return search( nums, target, 0, nums.size() - 1);
    }

     int search(vector<int>& nums, int target, int begin, int end) {
        if(nums[begin] == target) {
            return begin;
        } 

        if(end <= begin) {
            return -1;
        } 
        if(nums[(begin + end)/2] == target) {
            return (begin + end)/2;
        } 
        if(nums[begin] > target) {
            if(nums[(begin + end)/2] > target) {
                if(nums[(begin + end)/2] > nums[begin]) {
                    return search( nums, target, (begin + end) / 2 + 1, end);
                } else {
                    return search( nums, target, begin +1 , (begin + end) / 2 -1);
                }
            } else {
                return search( nums, target, (begin + end) / 2 + 1, end);
            }
        } else {
            if(nums[(begin + end)/2] > nums[begin]) {
                if(nums[(begin + end)/2] > target) {
                    return search( nums, target, begin +1 , (begin + end) / 2 -1);
                } else {
                    return search( nums, target, (begin + end) / 2 + 1, end);
                    
                }    
                
            } else {
                if(nums[(begin + end)/2] > target) {
                    return search( nums, target, (begin + end) / 2 + 1, end);
                } else {
                    return search( nums, target, begin +1 , (begin + end) / 2 -1);
                    
                }    
            }                    
        }
        return -1;
    }
};