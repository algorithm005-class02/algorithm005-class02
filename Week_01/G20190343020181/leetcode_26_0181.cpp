//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
#include <vector>

using namespace std;
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int cur_num = nums[0];
        int i = 1;
        int j = 1;
        for (; i < nums.size(); i++)
        {
            if (cur_num != nums[i])
            {
                nums[j++] = nums[i];
                cur_num = nums[i];
            }
        }
        for (;j < i; j++)
        {
            nums.pop_back();
        }
        return nums.size();
    };
};

int main()
{
    Solution s;

    vector<int> test;

    test.push_back(0);
    test.push_back(0);
    test.push_back(1);
    test.push_back(2);


    s.removeDuplicates(test); 
    return 0;




}

using namespace std;
class Solution2 {
public:
    int removeDuplicates(vector<int>& nums) {
        int i = 0;
        int j = 1;
        for (;j < nums.size();j++)
        {
            if (nums[i] != nums[j])
            {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    };
};