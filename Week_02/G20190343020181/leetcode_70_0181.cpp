
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 
 //使用递归
#include <unordered_map>
class Solution {
public:
    int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        auto iter = record_map.find(n);
        if (iter != record_map.end()) 
        return iter->second;
        int res = climbStairs(n - 1) + climbStairs(n - 2);
        record_map[n] = res;
        return res;
    }
    unordered_map<int,int> record_map;
};

//使用for
class Solution {
public:
   #include <unordered_map>
class Solution {
public:
    int climbStairs(int n) {
       if (n == 0) return 0;
       if (n == 1) return 1;
       if (n == 2) return 2;
       int a = 1;
       int b = 2;
       int res = 0;
       for (int i = 3; i < n + 1; i++)
       {
           res = a + b;
           a = b;
           b = res;
       }
       return res;
    }
};
};