class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        //暴力
        // for (int i = m; i < m + n; i++) {
        //    nums1[i] = nums2[i - m];
        //}
        // sort(nums1.begin(), nums1.end());
        // 逆向指针
        if (m == 0) {
            nums1 = nums2;
            return;
        }
        if (n == 0) return;
        int ptr1 = m - 1;
        int ptr2 = n - 1;
        int endPtr = m + n - 1;
        while (endPtr >= 0) {
            while (nums1[ptr1] <= nums2[ptr2] && ptr2 >= 0) {
                nums1[endPtr] = nums2[ptr2];
                endPtr--;
                ptr2--;
            }
            while (nums1[ptr1] > nums2[ptr2] && ptr1 >= 0) {
                nums1[endPtr] = nums1[ptr1];
                endPtr--;
                ptr1--;
            }
            if (ptr1 < 0) break;
        }
        if (ptr1 < 0) {
            for (int i = 0; i <= ptr2; i++) {
                nums1[i] = nums2[i];
            }
        }
    }
};