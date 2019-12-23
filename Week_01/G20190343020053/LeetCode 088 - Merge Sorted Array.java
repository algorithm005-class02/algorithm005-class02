class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int r1 = m - 1;
        int r2 = n - 1;
        int tail = m + n - 1;
        
        while (tail >= 0) {
            if (r1 >= 0 && r2 >= 0) {
                nums1[tail--] = nums1[r1] > nums2[r2] ? nums1[r1--] : nums2[r2--];
            } else if (r2 >= 0) {
                nums1[tail--] = nums2[r2--];
            } else {
                tail--;
            }
        }
    }
}