class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //从后向前遍历 时间复杂度为O(n)  执行用时0ms,内存消耗36.2MB
        m -= 1;
        n -= 1;
        int size = m + n + 1;
        while(m >= 0 && n >= 0){
            if (nums1[m] > nums2[n]){
                nums1[size] = nums1[m];
                m--;
                size--;
            }else if(nums1[m] < nums2[n]){
                nums1[size] = nums2[n];
                n--;
                size--;
            }else {
                nums1[size] = nums1[m];
                nums1[size-1] = nums2[n];
                m--;
                n--;
                size -=2;
            }
        }
        if( m == -1 && n != -1){
            for (;size >= 0; size--){
                nums1[size] = nums2[n];
                n--;
            }
        }else if (m != -1 && n == -1){
            for (;size >= 0; size--){
                nums1[size] = nums1[m];
                m--;
            }
        }
    }
}