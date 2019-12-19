#include <vector>
using namespace std;

class Solution {
public:
    // 双指针，两个指针各遍历一遍 O(n)
    void moveZeroes(vector<int>& nums) {
        if (nums.size() <= 1) return;  // 长度小于2的数组直接返回
        int zeroPtr = 0;               // 找0指针
        int nonzeroPtr = 0;            // 找非0指针
        while (zeroPtr < nums.size() &&
               nonzeroPtr < nums.size()) {  // 任意一个指针到尾部则结束
            while (nums[zeroPtr] != 0) {  // 找到第一个0
                zeroPtr++;
                if (zeroPtr == nums.size()) {
                    return;  // 下标越界意味着最后一个0已经处理，直接返回
                }
            }
            while (nums[nonzeroPtr] == 0) {  // 找到第一个非0
                nonzeroPtr++;
                if (nonzeroPtr == nums.size()) {
                    return;  // 下标越界直接返回
                }
            }
            if (zeroPtr < nonzeroPtr) {  // 如果0的位置靠前，交换
                nums[zeroPtr] = nums[nonzeroPtr];
                nums[nonzeroPtr] = 0;
            } else {  // 否则 继续找下一个非0
                nonzeroPtr++;
            }
        }
    }
};