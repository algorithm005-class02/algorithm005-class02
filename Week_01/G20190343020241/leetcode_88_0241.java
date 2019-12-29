import java.util.Arrays;

/**
 * 解题思路：
 * 	1.直接用Java Api,复制数组并排序，时间复杂度：O((n+m)log(n+m))，时间复杂度比较差，因为没有利用两个数组本身已经有序
 * 	2.有序数组通过 双指针达到O(n+m)的时间复杂度
 * 		将指针p1做为num1的开头，p2做为num2的开头，将每一步最小值放在输出数组中
 * 		由于num1是用于输出数组，将num1中的前m个元素放在其他地方，也就是需要O(m)的空间复杂度
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution88 {

    //time complexity:O((n+m)log(n+m))
    //space complexity:O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num1_copy = new int[m];
        System.arraycopy(nums1, 0, num1_copy, 0, m);
        int p1=1,p2=0,p=0;
        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = num1_copy[p1] < nums2[p2] ? num1_copy[p1++] : nums2[p2++];
        }
        if (p1 < m) {
            System.arraycopy(num1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < m) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }


    //time complexity:O((n+m)log(n+m))
    //space complexity:O(1)
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
