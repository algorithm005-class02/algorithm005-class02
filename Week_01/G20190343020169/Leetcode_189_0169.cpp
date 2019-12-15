/*
 * @lc app=leetcode.cn id=189 lang=cpp
 *
 * [189] 旋转数组
 */

// @lc code=start
#include<stdio.h>
#include<iostream>
#include<ctype.h>
#include<vector>

using namespace std;

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if(nums.size() == k) return ;
        if(k > nums.size()) k = k % nums.size();
        reverse1(nums, 0, nums.size() - k - 1);
        reverse1(nums, nums.size() - k, nums.size() - 1);
        reverse1(nums, 0, nums.size() - 1);
    }

    void reverse1(vector<int>& nums, int from, int to){
        while(from != to && from < to){
            int temp = nums[from];
            nums[from++] = nums[to];
            nums[to--] = temp;
        }
    }
};
// @lc code=end


