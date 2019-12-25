/*
 * @lc app=leetcode.cn id=1 lang=cpp
 *
 * [1] 两数之和
 */

// @lc code=start
#include<stdio.h>
#include<iostream>
#include<ctype.h>
#include<map>
#include<vector>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;

        if(nums.size() <= 1){
            return result;
        }

        map<int, int> map;

        for(int i = 0; i <= nums.size() - 1; i++){
            int tofind = target - nums[i];

            if(map.find(tofind) != map.end()){
                result.push_back(min(i,map[tofind]));
                result.push_back(max(i,map[tofind]));
                return result;
            }

            map[nums[i]] = i;
        }

        return result;
    }
};
// @lc code=end

