package algorithm.leetcode.二叉树;


/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L153_min_in_rotate {

    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length-1;

        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return nums[0]<nums[1]?nums[0]:nums[1];
        }

        while(start<=end){
            int middle = (end+start)>>1;
            if(isMiddleMin(nums,middle))
                return nums[middle];
            if(nums[middle]>=nums[start]){
                //左边是严格递增的。
                if(nums[start]>=nums[end]){
                    //最小值在右边
                    start = middle+1;
                }else{
                    //最小值在左边,就是start
                    return nums[start];
                }
            }else{
                //右边是严格递增的。中间那个值不是最小值，那只能在左边
                end = middle-1;

            }
        }


        return 0;
    }

    public boolean isMiddleMin(int[] nums, int middle){
        int middle_num=nums[middle];
        int m_next_num = middle_num;
        int m_prev_num = middle_num;
        if(middle<(nums.length-1))
        {
            m_next_num = nums[middle+1];
        }
        if(middle>0){
            m_prev_num = nums[middle-1];
        }

        if(middle_num<=m_next_num && middle_num<=m_prev_num){
            return true;
        }
        return false;

    }


    public static void main(String args[]){
        L153_min_in_rotate s = new L153_min_in_rotate();
        System.out.println(s.findMin(new int[]{3,4,5,1,2}));
    }
}
