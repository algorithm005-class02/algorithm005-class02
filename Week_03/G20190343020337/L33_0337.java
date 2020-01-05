package algorithm.leetcode.二叉树;


/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 */
public class L33_search_rotated_array {
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length-1;
        while(start<=end){

            int middle = (start+end)>>1;
            System.out.println(start+" "+end);
            if(nums[middle]==target){
                return middle;
            }
            if(nums[middle]>=nums[start]){
                //左半部分是严格升序的
                if(target<=nums[middle] && target>=nums[start]){
                    //数据在左边，左边是升序的
                    end = middle-1;
                }else{
                    //数据在右边
                    start = middle+1;
                }

            }else if(nums[end]>nums[middle]){
                //右半部分升序
                if(target>nums[middle] && target <= nums[end]){
                    start = middle+1;
                }else {
                    end = middle-1;
                }

            }

        }
        return -1;

    }

    public static void main(String args[]){
        int[] arr={5,1,3};
        L33_search_rotated_array so = new L33_search_rotated_array();
        System.out.println(so.search(arr,0));
    }
}
