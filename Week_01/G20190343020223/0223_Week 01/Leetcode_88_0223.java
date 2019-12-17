import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
          while(n!=0&&m!=0){
              int i=m;
              int j=n;
              nums1[m+n-1]=(nums1[i-1]>=nums2[j-1])?nums1[(m--)-1]:nums2[(n--)-1];
          }
          if(m==0){
              for(int i=0;i<n;i++){
                  nums1[i]=nums2[i];
              }
          }
    }
}
// @lc code=end

/* 
方法一：先将整第二个数组放到第一个数组的后面，然后再整体排序一下就好
        for (int i=0;i<nums2.length;i++){
            nums1[m+i]=nums2[i];
        }
        Arrays.sort(nums1);  
*/