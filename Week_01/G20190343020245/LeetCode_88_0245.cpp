//没有空间复杂度的限制
//最值的做法是新创建一个数组，把nums1和nums2中的元素依次比较放入新数组
//最后把新数组中的数据拷贝到nums1
class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        vector<int> numsResult(0,m+n);
        int index1 = 0;
        int index2 = 0;
        while(index1 < m && index2 < n) {
            if (nums1[index1] > nums2[index2]) {
                numsResult.push_back(nums2[index2]);
                index2++;
            } else {
                numsResult.push_back(nums1[index1]);
                index1++;
            }
        }

        while (index1 < m) {
            numsResult.push_back(nums1[index1]);
            index1++;
        }
        while (index2 < n) {
            numsResult.push_back(nums2[index2]);
            index2++;
        }
        int index = 0;
        for(int i : numsResult) {
            nums1[index++] = i;
        }
    }
};
